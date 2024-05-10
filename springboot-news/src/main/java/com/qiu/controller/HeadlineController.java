package com.qiu.controller;

import com.qiu.pojo.Headline;
import com.qiu.service.HeadlineService;
import com.qiu.utils.JwtHelper;
import com.qiu.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("headline")
public class HeadlineController {
    @Autowired
    private HeadlineService headlineService;
    @Autowired
    private JwtHelper jwtHelper;

    @PostMapping("publish")
    public Result publish(@RequestBody Headline headline, @RequestHeader String token){
        int userId = jwtHelper.getUserId(token).intValue();
        headline.setPublisher(userId);
        Result result = headlineService.publish(headline);
        return result;

    }
    @PostMapping("findHeadlineByHid")
    public Result findHeadlineByHid(Integer hid){
        Result result = headlineService.findHeadlineByHid(hid);
        return result;
    }
    @PostMapping("update")
    public Result updateHeadline(@RequestBody Headline headline){
        Result result = headlineService.updateHeadline(headline);
        return result;
    }
    @PostMapping("removeByHid")
    public Result removeByHid(Integer Hid){
        headlineService.removeById(Hid);
        return Result.ok(null);
    }
}
