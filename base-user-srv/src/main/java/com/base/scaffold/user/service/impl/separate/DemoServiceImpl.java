package com.base.scaffold.user.service.impl.separate;

import com.base.scaffold.user.business.request.base.BaseUserSrvRequest;
import com.base.scaffold.user.business.request.demo.DemoRequest;
import com.base.scaffold.user.business.response.base.BaseUserSrvResponse;
import com.base.scaffold.user.business.response.demo.DemoResponse;
import com.base.scaffold.user.service.separate.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author xiaochong.fan
 * @version 1.0
 * @date 2022/5/30 17:24
 * @description: DemoServiceImpl
 */
@Slf4j
@DubboService
public class DemoServiceImpl implements DemoService {

    @Override
    public BaseUserSrvResponse<DemoResponse> demoRequest(BaseUserSrvRequest<DemoRequest> baseUserSrvRequest) {

        DemoRequest demoRequest = baseUserSrvRequest.getBusiRequest();
        log.info(demoRequest.getUserId());

        DemoResponse demoResponse = new DemoResponse();
        demoResponse.setName("bjsimon");

        BaseUserSrvResponse<DemoResponse> baseUserSrvResponse =  new BaseUserSrvResponse<>();
        baseUserSrvResponse.setBusiResponse(demoResponse);
        return baseUserSrvResponse;
    }
}
