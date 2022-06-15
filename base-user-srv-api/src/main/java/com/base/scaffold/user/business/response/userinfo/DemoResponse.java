package com.base.scaffold.user.business.response.userinfo;

import com.base.scaffold.user.business.response.base.AdapterBaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author xiaochong.fan
 * @version 1.0
 * @date 2022/6/8 17:50
 * @description: 用户信息响应
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class DemoResponse extends AdapterBaseResponse {
    private static final long serialVersionUID = -7865602480778074814L;

    private String name;
}
