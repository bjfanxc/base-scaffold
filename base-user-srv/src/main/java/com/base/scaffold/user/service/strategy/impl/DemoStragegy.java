package com.base.scaffold.user.service.strategy.impl;

import com.base.scaffold.user.annotation.ApiName;
import com.base.scaffold.user.business.api.BaseUserSrvApi;
import com.base.scaffold.user.business.request.userinfo.DemoRequest;
import com.base.scaffold.user.business.response.base.BaseUserSrvResponse;
import com.base.scaffold.user.business.response.userinfo.DemoResponse;
import com.base.scaffold.user.checker.impl.DemoChecker;
import com.base.scaffold.user.enums.BusiResultCode;
import com.base.scaffold.user.exception.BusinessException;
import com.base.scaffold.user.service.strategy.BaseUserSrvStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author xiaochong.fan
 * @version 1.0
 * @date 2022/6/8 17:49
 * @description: demo
 */
@Slf4j
@Component
@ApiName(apiMehodName = BaseUserSrvApi.USER_DETAIL)
public class DemoStragegy implements BaseUserSrvStrategy<DemoRequest, DemoResponse> {

    @Resource
    private DemoChecker demoChecker;

    @Override
    public BaseUserSrvResponse<DemoResponse> process(DemoRequest busiRequest) throws BusinessException {
        BaseUserSrvResponse<DemoResponse> baseUserSrvResponse = new BaseUserSrvResponse<>();
        baseUserSrvResponse.setStatus(BusiResultCode.BUSI_ERROR.getStatus());
        baseUserSrvResponse.setMessage(BusiResultCode.BUSI_ERROR.getMessage());

        try {
            demoChecker.checkField(busiRequest);
            DemoResponse busiResponse = new DemoResponse();
            busiResponse.setName("bjfanxc");

            baseUserSrvResponse.setBusiResponse(busiResponse);
            baseUserSrvResponse.setStatus(BusiResultCode.BUSI_SUCCESS.getStatus());
            baseUserSrvResponse.setMessage(BusiResultCode.BUSI_SUCCESS.getMessage());
        } catch (BusinessException e) {
            throw e;
        } catch (Exception e) {
            log.error("DemoStragegy process error", e);
            throw new BusinessException(BusiResultCode.SYS_ERROR.getStatus(), BusiResultCode.SYS_ERROR.getMessage());
        }
        return baseUserSrvResponse;
    }
}
