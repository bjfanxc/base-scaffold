package com.base.scaffold.user.checker.impl;

import com.base.scaffold.user.business.request.userinfo.DemoRequest;
import com.base.scaffold.user.checker.FieldChecker;
import com.base.scaffold.user.exception.FieldInvalidException;
import org.springframework.stereotype.Component;

/**
 * @author xiaochong.fan
 * @version 1.0
 * @date 2022/6/15 16:06
 * @description: demochecker
 */
@Component
public class DemoChecker implements FieldChecker<DemoRequest> {

    @Override
    public void checkField(DemoRequest busiRequest) throws FieldInvalidException {

    }
}
