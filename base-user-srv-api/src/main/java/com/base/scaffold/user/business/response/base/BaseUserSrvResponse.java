package com.base.scaffold.user.business.response.base;

import com.base.scaffold.user.business.BaseUserSrvDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author xiaochong.fan
 * @version 1.0
 * @date 2022/6/8 16:08
 * @description: 接口响应类包装
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BaseUserSrvResponse<T extends AdapterBaseResponse> extends BaseUserSrvDTO {
    private static final long serialVersionUID = 6700649352859313728L;
    /**
     * 响应状态码
     */
    private int status;
    /**
     * 响应信息
     */
    private String message;
    /**
     * 业务响应参数
     */
    private T busiResponse;
}
