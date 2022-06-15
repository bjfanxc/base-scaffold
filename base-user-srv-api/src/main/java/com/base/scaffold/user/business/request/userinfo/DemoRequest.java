package com.base.scaffold.user.business.request.userinfo;

import com.base.scaffold.user.business.request.base.AdapterBaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author xiaochong.fan
 * @version 1.0
 * @date 2022/6/8 17:50
 * @description: 用户信息请求
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class DemoRequest extends AdapterBaseRequest {
    private static final long serialVersionUID = -6407335102113321702L;

    private String userId;
}
