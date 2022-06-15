package com.base.scaffold.user.enums;

/**
 * @author xiaochong.fan
 * @version 1.0
 * @date 2022/6/9 11:12
 * @description: 服务响应状态码
 */
public enum BusiResultCode {
    // 请求成功，未发生业务异常，不代表业务处理正确，具体业务需要自行判断response返回值
    BUSI_SUCCESS(0, "请求成功"),
    // 业务错误
    BUSI_ERROR(400, "处理失败"),
    // 系统错误
    SYS_ERROR(500, "系统内部错误"),
    ;

    private int status;
    private String message;

    BusiResultCode(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
