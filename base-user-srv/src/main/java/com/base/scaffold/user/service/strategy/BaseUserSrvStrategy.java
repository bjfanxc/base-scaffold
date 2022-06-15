package com.base.scaffold.user.service.strategy;

import com.base.scaffold.user.business.request.base.AdapterBaseRequest;
import com.base.scaffold.user.business.response.base.AdapterBaseResponse;
import com.base.scaffold.user.business.response.base.BaseUserSrvResponse;
import com.base.scaffold.user.exception.BusinessException;

/**
 * @author xiaochong.fan
 * @version 1.0
 * @date 2022/6/8 17:28
 * @description: 用户中台请求处理策略
 */
public interface BaseUserSrvStrategy<K extends AdapterBaseRequest, V extends AdapterBaseResponse> {

    /**
     * @author xiaochong.fan
     * @date 2022/6/8 18:02
     * @version 1.0
     * @description: 具体接口请求处理
     */
    BaseUserSrvResponse<V> process(K busiRequest) throws BusinessException;
}
