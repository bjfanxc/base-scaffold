package com.simon.scaffold.user.service.impl;

import com.simon.scaffold.entity.po.CityPO;
import com.simon.scaffold.user.service.CityService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author xiaochong.fan
 * @version 1.0
 * @date 2022/5/30 17:24
 * @description: CityServiceImpl
 */
@DubboService
public class CityServiceImpl implements CityService {

    @Override
    public CityPO getCityById(String cityId) {
        return CityPO.builder().id(1890).name("Shanghai").countryCode("CHN").district("Shanghai").population(9696300).build();
    }
}
