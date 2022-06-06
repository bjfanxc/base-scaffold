package com.simon.scaffold.user.service;

import com.simon.scaffold.entity.po.CityPO;

/**
 * @author xiaochong.fan
 * @version 1.0
 * @date 2022/5/30 17:23
 * @description: CitySerivce
 */
public interface CityService {

    CityPO getCityById(String cityId);
}
