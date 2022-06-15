package com.base.scaffold.user.checker;

import com.base.scaffold.user.business.request.base.BaseUserSrvRequest;
import com.base.scaffold.user.exception.BusinessException;
import com.base.scaffold.user.exception.FieldInvalidException;

public abstract class BaseCheckTemplate {

    public final void preCheck(BaseUserSrvRequest baseUserSrvRequest) throws BusinessException {
        paramsValidate(baseUserSrvRequest);
        paramsDecrypt(baseUserSrvRequest);
        riskControl(baseUserSrvRequest);
    }
    /**
     * 基础参数校验
     */
    protected abstract void paramsValidate(BaseUserSrvRequest baseUserSrvRequest) throws FieldInvalidException;

    /**
     * 参数解密处理
     */
    protected abstract void paramsDecrypt(BaseUserSrvRequest baseUserSrvRequest) throws BusinessException;

    /**
     * 风控检测
     */
    protected abstract void riskControl(BaseUserSrvRequest baseUserSrvRequest) throws BusinessException;
}
