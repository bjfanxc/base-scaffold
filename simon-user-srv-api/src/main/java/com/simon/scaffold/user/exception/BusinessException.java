package com.simon.scaffold.user.exception;

/**
 * @author xiaochong.fan
 * @version 1.0
 * @date 2022/6/8 17:41
 * @description: 业务异常包装
 */
public class BusinessException extends Exception {
    private static final long serialVersionUID = 3774974379131075055L;

    private String status;
    private String message;
    private Object data;

    public BusinessException() {
        super();
    }

    public BusinessException(String status, String message) {
        super(message);
        this.status = status;
        this.message = message;
    }

    public BusinessException(String status, String message, Object data) {
        super(message);
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BusinessException{" + "status='" + status + '\'' + ", message='" + message + '\'' + ", data=" + data + '}';
    }
}
