package com.sunyinuo.auditreportgame.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sunyinuo.auditreportgame.model.ReportMassage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * @author sunyinuo
 */
@RestController
@RequestMapping("/auditreportgame/api")
@Slf4j
public class ApiController {
    RedisTemplate<Object,Object> redisTemplate;

    public ApiController(RedisTemplate<Object, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }


    @GetMapping("/getReportMassage")
    public String getReportMassage(){

       Set<Object> obj =  Objects.requireNonNull(redisTemplate.keys("*"));
       List<ReportMassage> reportMassage = new ArrayList<>();

        for (Object o : obj) {
            String text = (String) o;
            reportMassage.add(JSONObject.parseObject(text,ReportMassage.class));
        }

        return JSONArray.toJSONString(reportMassage);
    }

}
