package com.qiu.service;

import com.qiu.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qiu.utils.Result;

/**
* @author QZF
* @description 针对表【news_user】的数据库操作Service
* @createDate 2024-03-13 15:50:57
*/
public interface UserService extends IService<User> {

    Result<User> login(User user);

    Result getUserInfo(String token);

    Result checkUserName(String username);

    Result regist(User user);
}
