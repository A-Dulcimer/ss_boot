package com.qiu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiu.Main;
import com.qiu.pojo.Headline;
import com.qiu.service.HeadlineService;
import com.qiu.mapper.HeadlineMapper;
import com.qiu.utils.Result;
import com.qiu.vo.PortalVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
* @author QZF
* @description 针对表【news_headline】的数据库操作Service实现
* @createDate 2024-03-13 15:50:57
*/
@Service
public class HeadlineServiceImpl extends ServiceImpl<HeadlineMapper, Headline>
    implements HeadlineService{
    @Autowired
    private HeadlineMapper headlineMapper;

    @Override
    public Result findNewsPage(PortalVo portalVo) {
        IPage<Headline> page = new Page(portalVo.getPageNum(), portalVo.getPageSize());
        LambdaQueryWrapper<Headline> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(!StringUtils.isEmpty(portalVo.getKeyWords()), Headline::getType,portalVo.getKeyWords())
                .eq(portalVo.getType()!=null,Headline::getType,portalVo.getType());
        headlineMapper.selectPageMap(page,portalVo);
        Map<String,Object> pageInfo = new HashMap<>();
        pageInfo.put("pageData",page.getRecords());
        pageInfo.put("pageNum",page.getCurrent());
        pageInfo.put("pageSize",page.getSize());
        pageInfo.put("totalPage",page.getPages());
        pageInfo.put("totalSize",page.getTotal());

        Map<String,Object> pageInfoMap=new HashMap<>();
        pageInfoMap.put("pageInfo",pageInfo);
        // 响应JSON
        return Result.ok(pageInfoMap);
    }

    @Override
    public Result showHeadlineDetail(Integer hid) {
        Map headlineDetail= headlineMapper.selectDetailMap(hid);
        Headline headline = new Headline();
        headline.setHid(hid);
        headline.setPageViews((Integer) headlineDetail.get("pageViews")+1);
        headline.setVersion((Integer) headlineDetail.get("version"));
        headlineMapper.updateById(headline);

        Map<String,Object> pageInfoMap = new HashMap<>();
        pageInfoMap.put("headline",headlineDetail);
        return Result.ok(pageInfoMap);
    }

    @Override
    public Result publish(Headline headline) {
        headline.setCreateTime(new Date());
        headline.setUpdateTime(new Date());
        headline.setPageViews(0);
        headlineMapper.insert(headline);
        return Result.ok(null);
    }

    @Override
    public Result findHeadlineByHid(Integer hid) {
        Headline headline = headlineMapper.selectById(hid);
        Map<String,Object> pageInfoMap=new HashMap<>();
        pageInfoMap.put("headline",headline);
        return Result.ok(pageInfoMap);
    }

    @Override
    public Result updateHeadline(Headline headline) {
        Integer version = headlineMapper.selectById(headline.getHid()).getVersion();
        headline.setVersion(version);
        headline.setUpdateTime(new Date());
        headlineMapper.updateById(headline);
        return Result.ok(null);
    }
}




