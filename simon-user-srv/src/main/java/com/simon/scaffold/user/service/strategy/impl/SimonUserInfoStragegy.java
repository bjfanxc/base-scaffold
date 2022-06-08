package com.simon.scaffold.user.service.strategy.impl;

import com.simon.scaffold.user.annotation.ApiName;
import com.simon.scaffold.user.business.api.SimonUserSrvApi;
import com.simon.scaffold.user.business.request.userinfo.UserInfoRequest;
import com.simon.scaffold.user.business.response.base.SimonUserSrvResponse;
import com.simon.scaffold.user.business.response.userinfo.UserInfoResponse;
import com.simon.scaffold.user.exception.BusinessException;
import com.simon.scaffold.user.service.strategy.SimonUserSrvStrategy;
import org.springframework.stereotype.Component;

/**
 * @author xiaochong.fan
 * @version 1.0
 * @date 2022/6/8 17:49
 * @description: 用户信息接口
 */
@Component
@ApiName(apiMehodName = SimonUserSrvApi.USER_DETAIL)
public class SimonUserInfoStragegy implements SimonUserSrvStrategy<UserInfoRequest, UserInfoResponse> {

    @Override
    public SimonUserSrvResponse<UserInfoResponse> process(UserInfoRequest busiRequest) throws BusinessException {
        return null;
    }
}
