package com.simon.scaffold.user.business;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xiaochong.fan
 * @version 1.0
 * @date 2022/6/8 16:10
 * @description: 公共请求参数，需要在统一请求响应类中继承
 */
@Data
public class SimonUserSrvDTO implements Serializable {
    private static final long serialVersionUID = -7585268072936951523L;

    /**
     * 请求流水号
     */
    private String transId;
    /**
     * 请求IP
     */
    private String requestIp;
    /**
     * 时间戳
     */
    private Long timestamp;
    /**
     * 版本号
     */
    private String version;
}
