package com.study.dynamicdata.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.study.dynamicdata.dao.SeckillSkuInfoMapper;
import com.study.dynamicdata.model.SeckillSkuInfo;
import com.study.dynamicdata.service.SeckillSkuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author luohx
 * @version 1.0.0
 * @date: 2023/9/20 下午10:56
 * @menu
 */
@Service
@DS("read")
public class SeckillSkuInfoServiceImpl implements SeckillSkuInfoService {

    @Autowired
    private SeckillSkuInfoMapper skuInfoMapper;

    @Override
    public int update(String id) {
        SeckillSkuInfo seckillSkuInfo = skuInfoMapper.selectById(id);
        if (seckillSkuInfo == null) return 0;
        seckillSkuInfo.setLimitNum(5);
        return skuInfoMapper.updateById(seckillSkuInfo);
    }
}
