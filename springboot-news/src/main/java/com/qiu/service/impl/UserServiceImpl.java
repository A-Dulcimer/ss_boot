package com.qiu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiu.pojo.User;
import com.qiu.service.UserService;
import com.qiu.mapper.UserMapper;
import com.qiu.utils.JwtHelper;
import com.qiu.utils.MD5Util;
import com.qiu.utils.Result;
import com.qiu.utils.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
* @author QZF
* @description 针对表【news_user】的数据库操作Service实现
* @createDate 2024-03-13 15:50:57
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{
    @Autowired
    private JwtHelper jwtHelper;
    @Autowired
    private  UserMapper userMapper;
    @Override
    public Result login(User user) {
        //设置匹配条件
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername,user.getUsername());
        //数据库查询
        User loginUser = userMapper.selectOne(wrapper);
        //判断用户名
        if (loginUser == null){
            //用户名错误
            return Result.build(null, ResultCodeEnum.USERNAME_ERROR);
        }
        //判断密码
        if(!StringUtils.isEmpty(user.getUserPwd())
                && loginUser.getUserPwd().equals(MD5Util.encrypt(user.getUserPwd())))
        {
            //如果用户名和密码都正确,生成token
            String token = jwtHelper.createToken(Long.valueOf(loginUser.getUid()));
            //把token放到返回类中
            Map data = new HashMap();
            data.put("token",token);
            return Result.ok(data);
        }
        //密码错误
        return Result.build(null,ResultCodeEnum.PASSWORD_ERROR);
    }

    @Override
    public Result getUserInfo(String token) {
        //1.判定是否有效期
        if (jwtHelper.isExpiration(token)) {
            //true过期,直接返回未登录
            return Result.build(null,ResultCodeEnum.NOTLOGIN);
        }
        int userId = jwtHelper.getUserId(token).intValue();
        User user = userMapper.selectById(userId);
        if (user != null) {
            user.setUserPwd(null);
            Map data = new HashMap();
            data.put("loginUser",user);
            return Result.ok(data);
        }
        return Result.build(null,ResultCodeEnum.NOTLOGIN);
    }

    @Override
    public Result checkUserName(String username) {
        LambdaQueryWrapper<User> lqw=new LambdaQueryWrapper<>();
        lqw.eq(User::getUsername,username);
        User user = userMapper.selectOne(lqw);
        if (user != null){
            return Result.build(null,ResultCodeEnum.USERNAME_USED);
        }
        return Result.ok(null);
    }

    @Override
    public Result regist(User user) {
        LambdaQueryWrapper<User> lqw=new LambdaQueryWrapper<>();
        lqw.eq(User::getUsername,user.getUsername());
        Long count = userMapper.selectCount(lqw);
        if (count > 0){
            return Result.build(null,ResultCodeEnum.USERNAME_USED);
        }
        user.setUserPwd(MD5Util.encrypt(user.getUserPwd()));
        int row = userMapper.insert(user);
        System.out.println("row = " + row);
        return Result.ok(null);
    }
}




