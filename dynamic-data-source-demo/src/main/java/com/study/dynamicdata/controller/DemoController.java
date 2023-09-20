package com.study.dynamicdata.controller;

import com.alibaba.fastjson.JSON;
import com.study.dynamicdata.model.SeckillInfo;
import com.study.dynamicdata.service.SecKillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 多数据源切换实现
 *
 * @author luohx
 * @version 1.0.0
 * @date: 2023/9/19 下午11:51
 * @menu 多数据源切换实现
 */
@RequestMapping("/demo")
@RestController
public class DemoController {

    @Autowired
    private SecKillService secKillService;

    @GetMapping("/test_01_00")
    public String test_01_00() {
        return JSON.toJSONString(secKillService.selectById(null));
    }

    @GetMapping("/test_01_01")
    public String test_01_01() {
        SeckillInfo killInfo = new SeckillInfo("3", "国庆购物节",
                this.getDateByStr("2023-09-15 00:00:00"), this.getDateByStr("2023-10-20 00:00:00"), "庆祝建国购物狂欢节");
        int insert = secKillService.insert(killInfo);
        return insert + "";
    }

    /**
     * 日期转换
     *
     * @param dateStr
     * @return {@link Date}
     */
    private Date getDateByStr(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = sdf.parse(dateStr);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
