package com.simon.scaffold.user.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author xiaochong.fan
 * @version 1.0
 * @date 2022/6/8 17:41
 * @description: 业务异常包装
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BusinessException extends Exception {
    private static final long serialVersionUID = 3774974379131075055L;

    private int status;
    private String message;
    private Object data;

    public BusinessException() {
        super();
    }

    public BusinessException(int status, String message) {
        super(message);
        this.status = status;
        this.message = message;
    }

    public BusinessException(int status, String message, Object data) {
        super(message);
        this.status = status;
        this.message = message;
        this.data = data;
    }

    @Override
    public String toString() {
        return "BusinessException{" + "status='" + status + '\'' + ", message='" + message + '\'' + ", data=" + data + '}';
    }
}
