package com.study.dynamicdata.service;

import com.study.dynamicdata.model.SeckillInfo;

import java.util.List;

/**
 * 秒杀
 *
 * @author luohx
 * @version 1.0.0
 * @date: 2023/9/7 上午11:06
 * @menu 秒杀
 */
public interface SecKillService {

    /**
     * @param id
     * @return {@link List}<{@link SeckillInfo}>
     */
    List<SeckillInfo> selectById(String id);

    /**
     * @param seckillInfo
     * @return int
     */
    int insert(SeckillInfo seckillInfo);

}
