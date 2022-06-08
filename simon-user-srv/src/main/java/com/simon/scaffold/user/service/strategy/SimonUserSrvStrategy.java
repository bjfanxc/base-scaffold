package com.simon.scaffold.user.service.strategy;

import com.simon.scaffold.user.business.request.base.AdapterBaseRequest;
import com.simon.scaffold.user.business.response.base.AdapterBaseResponse;
import com.simon.scaffold.user.business.response.base.SimonUserSrvResponse;
import com.simon.scaffold.user.exception.BusinessException;

/**
 * @author xiaochong.fan
 * @version 1.0
 * @date 2022/6/8 17:28
 * @description: 用户中台请求处理策略
 */
public interface SimonUserSrvStrategy<K extends AdapterBaseRequest, V extends AdapterBaseResponse> {

    /**
     * @author xiaochong.fan
     * @date 2022/6/8 18:02
     * @version 1.0
     * @description: 具体接口请求处理
     */
    SimonUserSrvResponse<V> process(K busiRequest) throws BusinessException;
}
