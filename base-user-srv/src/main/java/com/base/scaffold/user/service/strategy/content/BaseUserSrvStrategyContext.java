package com.base.scaffold.user.service.strategy.content;

import com.base.scaffold.user.annotation.ApiName;
import com.base.scaffold.user.business.request.base.AdapterBaseRequest;
import com.base.scaffold.user.business.response.base.AdapterBaseResponse;
import com.base.scaffold.user.service.strategy.BaseUserSrvStrategy;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xiaochong.fan
 * @version 1.0
 * @date 2022/6/8 17:27
 * @description: 请求处理策略上下文
 */
@Component
public class BaseUserSrvStrategyContext {

    private final Map<String, BaseUserSrvStrategy> baseUserSrvStrategyMap = new ConcurrentHashMap<>();

    public BaseUserSrvStrategyContext(Map<String, BaseUserSrvStrategy> baseUserSrvStrategys) {

        baseUserSrvStrategys.forEach((k, v) -> this.baseUserSrvStrategyMap.put(
                Objects.requireNonNull(AnnotationUtils.findAnnotation(v.getClass(), ApiName.class)).apiMehodName(), v));
    }

    public BaseUserSrvStrategy<AdapterBaseRequest, AdapterBaseResponse> getRequestStrategy(String apiMethodName) {
        return baseUserSrvStrategyMap.get(apiMethodName);
    }
}
