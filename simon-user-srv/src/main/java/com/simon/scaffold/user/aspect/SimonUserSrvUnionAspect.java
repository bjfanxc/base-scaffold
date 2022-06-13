package com.simon.scaffold.user.aspect;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Stopwatch;
import com.simon.scaffold.user.business.request.base.AdapterBaseRequest;
import com.simon.scaffold.user.business.request.base.SimonUserSrvRequest;
import com.simon.scaffold.user.business.response.base.AdapterBaseResponse;
import com.simon.scaffold.user.business.response.base.SimonUserSrvResponse;
import com.simon.scaffold.user.enums.BusiResultCode;
import com.simon.scaffold.user.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

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
public class SimonUserSrvUnionAspect {

    @Pointcut("execution(* com.simon.scaffold.user.service.impl.union.*.*(..))")
    public void pointCut() {}

    @Around("pointCut() && args(simonUserSrvRequest)")
    public SimonUserSrvResponse<AdapterBaseResponse> around(ProceedingJoinPoint joinPoint,
                                                            SimonUserSrvRequest<? extends AdapterBaseRequest> simonUserSrvRequest) throws Throwable {
        SimonUserSrvResponse<AdapterBaseResponse> simonUserSrvResponse =
                SimonUserSrvResponse.builder().status(BusiResultCode.SYS_ERROR.getStatus()).message(BusiResultCode.SYS_ERROR.getMessage()).build();

        try {
            //请求报文
            log.info("simon_user_srv_request:{}", JSON.toJSONString(simonUserSrvRequest));
            //参数校验
            log.info("simonUserSrvCheckTemplate.preCheck(simonUserSrvRequest);");
            //开启计时器
            Stopwatch stopwatch = Stopwatch.createStarted();
            //请求处理
            simonUserSrvResponse = (SimonUserSrvResponse) joinPoint.proceed();
            //停止计时器
            stopwatch.stop();
            //封装结果 设置流水，ip，版本号，响应时间戳
            simonUserSrvResponse.setTransId(simonUserSrvRequest.getTransId());
            simonUserSrvResponse.setRequestIp(simonUserSrvRequest.getRequestIp());
            simonUserSrvResponse.setTimestamp(System.currentTimeMillis());
            simonUserSrvResponse.setVersion(simonUserSrvRequest.getVersion());
            //响应结果
            log.info("simon_user_srv_response:{}", JSON.toJSONString(simonUserSrvResponse));
            log.info("{}|{} rt:{}", simonUserSrvRequest.getMethod(), simonUserSrvRequest.getTransId(), stopwatch.elapsed(TimeUnit.MILLISECONDS));
        } catch (BusinessException be) {
            simonUserSrvResponse.setStatus(be.getStatus());
            simonUserSrvResponse.setMessage(be.getMessage());
        } catch (Exception e) {
            log.error("simon_user_srv_aspect_exception", e);
        } finally {
            log.info("ThreadLocalUtil.remove();");
        }
        return simonUserSrvResponse;
    }
}
