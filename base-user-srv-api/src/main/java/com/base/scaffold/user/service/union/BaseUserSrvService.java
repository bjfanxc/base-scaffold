package com.base.scaffold.user.service.union;

import com.base.scaffold.user.business.request.base.AdapterBaseRequest;
import com.base.scaffold.user.business.request.base.BaseUserSrvRequest;
import com.base.scaffold.user.business.response.base.AdapterBaseResponse;
import com.base.scaffold.user.business.response.base.BaseUserSrvResponse;

/**
 * @author xiaochong.fan
 * @version 1.0
 * @date 2022/6/8 16:01
 * @description: 用户中台业务接口
 */
public interface BaseUserSrvService<K extends AdapterBaseRequest, V extends AdapterBaseResponse> {

    BaseUserSrvResponse<V> dispatcher(BaseUserSrvRequest<K> baseUserSrvRequest);
}
