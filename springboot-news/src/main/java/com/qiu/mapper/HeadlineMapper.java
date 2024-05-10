package com.qiu.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qiu.pojo.Headline;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qiu.vo.PortalVo;

import java.util.Map;

/**
* @author QZF
* @description 针对表【news_headline】的数据库操作Mapper
* @createDate 2024-03-13 15:50:57
* @Entity com.qiu.pojo.Headline
*/
public interface HeadlineMapper extends BaseMapper<Headline> {

    IPage<Map> selectPageMap(IPage<Headline> page, PortalVo portalVo);

    Map selectDetailMap(Integer hid);
}




