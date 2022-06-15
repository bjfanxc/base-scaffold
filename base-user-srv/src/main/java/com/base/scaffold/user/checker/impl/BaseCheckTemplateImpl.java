package com.base.scaffold.user.checker.impl;

import cn.hutool.core.text.CharSequenceUtil;
import com.base.scaffold.user.business.request.base.BaseUserSrvRequest;
import com.base.scaffold.user.checker.BaseCheckTemplate;
import com.base.scaffold.user.enums.BusiResultCode;
import com.base.scaffold.user.exception.BusinessException;
import com.base.scaffold.user.exception.FieldInvalidException;
import org.springframework.stereotype.Component;

/**
 * @author xiaochong.fan
 * @version 1.0
 * @date 2022/6/15 16:14
 * @description: aspect checker
 */
@Component
public class BaseCheckTemplateImpl extends BaseCheckTemplate {

    @Override
    protected void paramsValidate(BaseUserSrvRequest baseUserSrvRequest) throws FieldInvalidException {
        if(CharSequenceUtil.isBlank(baseUserSrvRequest.getTransId())){
            throw new FieldInvalidException(BusiResultCode.BUSI_ERROR.getStatus(),
                    "transId不能为空");
        }
        if(CharSequenceUtil.isBlank(baseUserSrvRequest.getMethod())){
            throw new FieldInvalidException(BusiResultCode.BUSI_ERROR.getStatus(),
                    "方法名不能为空");
        }
        if(CharSequenceUtil.isBlank(baseUserSrvRequest.getRequestIp())){
            throw new FieldInvalidException(BusiResultCode.BUSI_ERROR.getStatus(),
                    "ip不能为空");
        }
        if(baseUserSrvRequest.getBusiRequest() == null){
            throw new FieldInvalidException(BusiResultCode.BUSI_ERROR.getStatus(),
                    "业务参数不能为空");
        }
    }

    @Override
    protected void paramsDecrypt(BaseUserSrvRequest baseUserSrvRequest) throws BusinessException {

    }

    @Override
    protected void riskControl(BaseUserSrvRequest baseUserSrvRequest) throws BusinessException {

    }
}
