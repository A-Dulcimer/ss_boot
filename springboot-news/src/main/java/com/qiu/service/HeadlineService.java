package com.qiu.service;

import com.qiu.pojo.Headline;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qiu.utils.Result;
import com.qiu.vo.PortalVo;

/**
* @author QZF
* @description 针对表【news_headline】的数据库操作Service
* @createDate 2024-03-13 15:50:57
*/
public interface HeadlineService extends IService<Headline> {
    Result findNewsPage(PortalVo portalVo);

    Result showHeadlineDetail(Integer hid);

    Result publish(Headline headline);

    Result findHeadlineByHid(Integer hid);

    Result updateHeadline(Headline headline);
}
