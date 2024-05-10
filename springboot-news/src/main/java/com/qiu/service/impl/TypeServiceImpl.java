package com.qiu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiu.mapper.HeadlineMapper;
import com.qiu.pojo.Headline;
import com.qiu.pojo.Type;
import com.qiu.service.TypeService;
import com.qiu.mapper.TypeMapper;
import com.qiu.utils.Result;
import com.qiu.vo.PortalVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author QZF
* @description 针对表【news_type】的数据库操作Service实现
* @createDate 2024-03-13 15:50:57
*/
@Service
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type>
    implements TypeService{

}




