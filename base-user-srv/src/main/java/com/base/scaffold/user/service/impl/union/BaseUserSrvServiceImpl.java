package com.base.scaffold.user.service.impl.union;

import com.base.scaffold.user.business.request.base.AdapterBaseRequest;
import com.base.scaffold.user.business.request.base.BaseUserSrvRequest;
import com.base.scaffold.user.business.response.base.AdapterBaseResponse;
import com.base.scaffold.user.business.response.base.BaseUserSrvResponse;
import com.base.scaffold.user.enums.BusiResultCode;
import com.base.scaffold.user.exception.BusinessException;
import com.base.scaffold.user.service.strategy.content.BaseUserSrvStrategyContext;
import com.base.scaffold.user.service.union.BaseUserSrvService;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

/**
 * @author xiaochong.fan
 * @version 1.0
 * @date 2022/6/8 17:18
 * @description: 用户中台业务接口，统一策略转发处理
 */
@DubboService
public class BaseUserSrvServiceImpl implements BaseUserSrvService<AdapterBaseRequest, AdapterBaseResponse> {

    @Resource
    private BaseUserSrvStrategyContext baseUserSrvStrategyContext;

    @Override
    public BaseUserSrvResponse<AdapterBaseResponse> dispatcher(BaseUserSrvRequest<AdapterBaseRequest> baseUserSrvRequest) {

        BaseUserSrvResponse<AdapterBaseResponse> baseUserSrvResponse = new BaseUserSrvResponse<>();
        baseUserSrvResponse.setStatus(BusiResultCode.BUSI_ERROR.getStatus());
        baseUserSrvResponse.setMessage(BusiResultCode.BUSI_ERROR.getMessage());

        try {
            baseUserSrvResponse = baseUserSrvStrategyContext.getRequestStrategy(baseUserSrvRequest.getMethod()).process(baseUserSrvRequest.getBusiRequest());
        } catch (BusinessException e) {
            baseUserSrvResponse.setStatus(e.getStatus());
            baseUserSrvResponse.setMessage(e.getMessage());
        }
        return baseUserSrvResponse;
    }
}
