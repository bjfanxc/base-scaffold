package com.simon.scaffold.user.business.response.base;

import com.simon.scaffold.user.business.SimonUserSrvDTO;
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
public class SimonUserSrvResponse<T extends AdapterBaseResponse> extends SimonUserSrvDTO {
    private static final long serialVersionUID = 6700649352859313728L;
    /**
     * 响应状态码
     */
    private String status;
    /**
     * 响应信息
     */
    private String message;
    /**
     * 业务响应参数
     */
    private T busiResponse;
}
