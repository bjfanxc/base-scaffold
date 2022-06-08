package com.simon.scaffold.user.business.request.base;

import com.simon.scaffold.user.business.SimonUserSrvDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author xiaochong.fan
 * @version 1.0
 * @date 2022/6/8 16:08
 * @description: 接口请求类包装
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SimonUserSrvRequest<T extends AdapterBaseRequest> extends SimonUserSrvDTO {
    private static final long serialVersionUID = 5260427375358394275L;

    /**
     * 请求接口名称，相当于http请求的path
     */
    private String method;
    /**
     * 通知地址，如需要第三方通知的请求，请传递通知地址
     */
    private String notifyUrl;
    /**
     * 通知队列名
     */
    private String notifyMqName;
    /**
     * 业务请求参数
     */
    private T busiRequest;
}
