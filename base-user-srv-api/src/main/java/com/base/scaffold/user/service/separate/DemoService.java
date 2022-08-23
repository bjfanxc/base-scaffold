package com.base.scaffold.user.service.separate;

import com.base.scaffold.user.business.request.base.BaseUserSrvRequest;
import com.base.scaffold.user.business.request.demo.DemoRequest;
import com.base.scaffold.user.business.response.base.BaseUserSrvResponse;
import com.base.scaffold.user.business.response.demo.DemoResponse;

/**
 * @author xiaochong.fan
 * @version 1.0
 * @date 2022/5/30 17:23
 * @description: DemoService
 */
public interface DemoService {

    BaseUserSrvResponse<DemoResponse> demoRequest(BaseUserSrvRequest<DemoRequest> baseUserSrvRequest);
}
