package com.base.scaffold.api.controller;

import com.alibaba.fastjson.JSON;
import com.base.scaffold.user.business.api.BaseUserSrvApi;
import com.base.scaffold.user.business.api.BaseUserSrvReqUtil;
import com.base.scaffold.user.business.request.userinfo.DemoRequest;
import com.base.scaffold.user.business.response.base.BaseUserSrvResponse;
import com.base.scaffold.user.business.response.userinfo.DemoResponse;
import com.base.scaffold.user.service.separate.DemoService;
import com.base.scaffold.user.service.union.BaseUserSrvService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.PostMapping;
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

    @DubboReference
    private DemoService demoService;
    @DubboReference
    private BaseUserSrvService baseUserSrvService;

    @PostMapping("/dispatcher")
    public void dispatcher() {
        BaseUserSrvReqUtil baseUserSrvReqUtil = new BaseUserSrvReqUtil<>(BaseUserSrvApi.USER_DETAIL, baseUserSrvService);
        DemoRequest demoRequest = new DemoRequest();
        demoRequest.setUserId("11111");
        BaseUserSrvResponse<DemoResponse> baseUserSrvResponse = baseUserSrvReqUtil.rpc(demoRequest);
        log.info(JSON.toJSONString(baseUserSrvResponse.getStatus()));
        log.info(JSON.toJSONString(baseUserSrvResponse.getMessage()));
        log.info(JSON.toJSONString(baseUserSrvResponse.getBusiResponse()));
    }

    @PostMapping("/separate")
    public void separate() {
        demoService.demoRequest();
    }
}
