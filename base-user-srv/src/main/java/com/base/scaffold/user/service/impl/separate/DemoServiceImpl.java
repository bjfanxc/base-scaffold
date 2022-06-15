package com.base.scaffold.user.service.impl.separate;

import com.base.scaffold.user.service.separate.DemoService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author xiaochong.fan
 * @version 1.0
 * @date 2022/5/30 17:24
 * @description: CityServiceImpl
 */
@DubboService
public class DemoServiceImpl implements DemoService {

    @Override
    public int demoRequest() {
        System.out.println("get city info");
        return 1;
    }
}
