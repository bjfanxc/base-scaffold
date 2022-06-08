package com.simon.scaffold.user.service.union;

import com.simon.scaffold.user.business.request.base.AdapterBaseRequest;
import com.simon.scaffold.user.business.request.base.SimonUserSrvRequest;
import com.simon.scaffold.user.business.response.base.AdapterBaseResponse;
import com.simon.scaffold.user.business.response.base.SimonUserSrvResponse;

/**
 * @author xiaochong.fan
 * @version 1.0
 * @date 2022/6/8 16:01
 * @description: 用户中台业务接口
 */
public interface SimonUserSrvService<K extends AdapterBaseRequest, V extends AdapterBaseResponse> {

    SimonUserSrvResponse<V> dispatcher(SimonUserSrvRequest<K> simonUserSrvRequest);
}
