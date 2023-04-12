package com.base.scaffold.api.controller;

import com.base.scaffold.account.service.BaseAccountSrvService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaochong.fan
 * @version 1.0
 * @date 2022/6/14 11:50
 * @description: demo
 */
@Slf4j
@RestController
@RequestMapping("/demo/srv")
public class DemoController {

//    @DubboReference
//    private DemoService demoService;
//    @DubboReference
//    private BaseUserSrvService baseUserSrvService;
    @DubboReference
    private BaseAccountSrvService baseAccountSrvService;

//    @PostMapping("/dispatcher")
//    public Object dispatcher() {
//        BaseUserSrvReqUtil baseUserSrvReqUtil = new BaseUserSrvReqUtil<>(BaseUserSrvApi.USER_DETAIL, baseUserSrvService);
//        DemoRequest demoRequest = new DemoRequest();
//        demoRequest.setUserId("11111");
//        BaseUserSrvResponse<DemoResponse> baseUserSrvResponse = baseUserSrvReqUtil.rpc(demoRequest);
//        log.info(JSON.toJSONString(baseUserSrvResponse.getStatus()));
//        log.info(JSON.toJSONString(baseUserSrvResponse.getMessage()));
//        log.info(JSON.toJSONString(baseUserSrvResponse.getBusiResponse()));
//        return baseUserSrvResponse;
//    }
//
//    @PostMapping("/separate")
//    public Object separate() {
//        DemoRequest demoRequest = new DemoRequest();
//        demoRequest.setUserId("22222");
//        BaseUserSrvRequest<DemoRequest> baseUserSrvRequest = new BaseUserSrvRequest<>();
//        baseUserSrvRequest.setBusiRequest(demoRequest);
//        BaseUserSrvResponse<DemoResponse> baseUserSrvResponse = demoService.demoRequest(baseUserSrvRequest);
//        log.info(JSON.toJSONString(baseUserSrvResponse.getStatus()));
//        log.info(JSON.toJSONString(baseUserSrvResponse.getMessage()));
//        log.info(JSON.toJSONString(baseUserSrvResponse.getBusiResponse()));
//        return baseUserSrvResponse;
//    }
}
