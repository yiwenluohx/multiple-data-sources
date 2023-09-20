package com.study.dynamicdata.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.google.common.collect.Lists;
import com.study.dynamicdata.dao.SeckillInfoMapper;
import com.study.dynamicdata.model.SeckillInfo;
import com.study.dynamicdata.service.SecKillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 秒杀
 *
 * @author luohx
 * @version 1.0.0
 * @date: 2023/9/7 上午11:08
 * @menu 秒杀
 */
@Service
@DS("read")
public class SecKillServiceImpl implements SecKillService {

    private final static Logger log = LoggerFactory.getLogger(SecKillServiceImpl.class);

    @Autowired
    private SeckillInfoMapper seckillInfoMapper;

    public List<SeckillInfo> selectById(String id) {
        if (StringUtils.isEmpty(id)) {
            return seckillInfoMapper.selectList(null);
        }
        SeckillInfo seckillInfo = seckillInfoMapper.selectById(id);
        return Lists.newArrayList(seckillInfo);
    }

    @DS("write")
    public int insert(SeckillInfo entity) {
        return seckillInfoMapper.insert(entity);
    }
}
