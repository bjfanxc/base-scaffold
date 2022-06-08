package com.simon.scaffold.user.service.impl.union;

import com.simon.scaffold.user.business.request.base.AdapterBaseRequest;
import com.simon.scaffold.user.business.request.base.SimonUserSrvRequest;
import com.simon.scaffold.user.business.response.base.AdapterBaseResponse;
import com.simon.scaffold.user.business.response.base.SimonUserSrvResponse;
import com.simon.scaffold.user.service.union.SimonUserSrvService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author xiaochong.fan
 * @version 1.0
 * @date 2022/6/8 17:18
 * @description: 用户中台业务接口
 */
@DubboService
public class SimonUserSrvServiceImpl implements SimonUserSrvService<AdapterBaseRequest, AdapterBaseResponse> {

    @Override
    public SimonUserSrvResponse<AdapterBaseResponse> dispatcher(SimonUserSrvRequest<AdapterBaseRequest> simonUserSrvRequest) {
        return null;
    }
}
