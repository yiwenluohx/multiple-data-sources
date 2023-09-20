package com.study.abstraceroutingdata.controller;

import com.alibaba.fastjson.JSON;
import com.study.abstraceroutingdata.config.DynamicDataSource;
import com.study.abstraceroutingdata.dao.SeckillInfoMapper;
import com.study.abstraceroutingdata.model.SeckillInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    private SeckillInfoMapper seckillInfoMapper;

    /**
     * 通过传参实现
     *
     * @return
     */
    @GetMapping("/test_01_00")
    public String test_01_00(@RequestParam(value = "dsKey", defaultValue="R") String dsKey) {
        DynamicDataSource.name.set(dsKey);
        SeckillInfo seckillInfo = seckillInfoMapper.selectById("2");
        return JSON.toJSONString(seckillInfo);
    }

    /**
     * 通过传参实现
     *
     * @return
     */
    @GetMapping("/test_01_01")
    public String test_01_01(@RequestParam(value = "dsKey", defaultValue="W") String dsKey) {
        DynamicDataSource.name.set(dsKey);
        SeckillInfo killInfo = new SeckillInfo("2", "618购物节",
                this.getDateByStr("2023-06-01 00:00:00"), this.getDateByStr("2023-10-10 00:00:00"), "京东主导的一场购物狂欢节");
        int insert = seckillInfoMapper.insert(killInfo);
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
