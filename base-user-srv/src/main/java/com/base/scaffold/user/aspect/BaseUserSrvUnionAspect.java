package com.base.scaffold.user.aspect;

import com.alibaba.fastjson.JSON;
import com.base.scaffold.user.business.request.base.AdapterBaseRequest;
import com.base.scaffold.user.business.request.base.BaseUserSrvRequest;
import com.base.scaffold.user.business.response.base.AdapterBaseResponse;
import com.base.scaffold.user.business.response.base.BaseUserSrvResponse;
import com.base.scaffold.user.checker.BaseCheckTemplate;
import com.base.scaffold.user.enums.BusiResultCode;
import com.base.scaffold.user.exception.BusinessException;
import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author xiaochong.fan
 * @version 1.0
 * @date 2022/6/9 10:44
 * @description: 统一策略转发切面
 */
@Slf4j
@Aspect
@Component
public class BaseUserSrvUnionAspect {

    @Resource
    private BaseCheckTemplate baseCheckTemplate;

    @Pointcut("execution(* com.base.scaffold.user.service.impl.union.*.*(..)) || execution(* com.base.scaffold.user.service.impl.separate.*.*(..))")
    public void pointCut() {}

    @Around("pointCut() && args(baseUserSrvRequest)")
    public BaseUserSrvResponse<AdapterBaseResponse> around(ProceedingJoinPoint joinPoint,
                                                           BaseUserSrvRequest<? extends AdapterBaseRequest> baseUserSrvRequest) throws Throwable {
        BaseUserSrvResponse<AdapterBaseResponse> baseUserSrvResponse = new BaseUserSrvResponse<>();
        baseUserSrvResponse.setStatus(BusiResultCode.SYS_ERROR.getStatus());
        baseUserSrvResponse.setMessage(BusiResultCode.SYS_ERROR.getMessage());

        try {
            //请求报文
            log.info("base_user_srv_request:{}", JSON.toJSONString(baseUserSrvRequest));
            //参数校验
            baseCheckTemplate.preCheck(baseUserSrvRequest);
            //开启计时器
            Stopwatch stopwatch = Stopwatch.createStarted();
            //请求处理
            baseUserSrvResponse = (BaseUserSrvResponse) joinPoint.proceed();
            //停止计时器
            stopwatch.stop();
            //封装结果 设置流水，ip，版本号，响应时间戳
            baseUserSrvResponse.setTransId(baseUserSrvRequest.getTransId());
            baseUserSrvResponse.setRequestIp(baseUserSrvRequest.getRequestIp());
            baseUserSrvResponse.setTimestamp(System.currentTimeMillis());
            baseUserSrvResponse.setVersion(baseUserSrvRequest.getVersion());
            //响应结果
            log.info("base_user_srv_response:{}", JSON.toJSONString(baseUserSrvResponse));
            log.info("{}|{} rt:{}", baseUserSrvRequest.getMethod(), baseUserSrvRequest.getTransId(), stopwatch.elapsed(TimeUnit.MILLISECONDS));
        } catch (BusinessException be) {
            baseUserSrvResponse.setStatus(be.getStatus());
            baseUserSrvResponse.setMessage(be.getMessage());
        } catch (Exception e) {
            log.error("base_user_srv_aspect_exception", e);
        } finally {
            log.info("ThreadLocalUtil.remove();");
        }
        return baseUserSrvResponse;
    }
}
