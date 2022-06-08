package com.simon.scaffold.user.service.strategy.content;

import com.simon.scaffold.user.annotation.ApiName;
import com.simon.scaffold.user.business.request.base.AdapterBaseRequest;
import com.simon.scaffold.user.business.response.base.AdapterBaseResponse;
import com.simon.scaffold.user.service.strategy.SimonUserSrvStrategy;
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
public class SimonUserSrvStrategyContext {

    private final Map<String, SimonUserSrvStrategy<? extends AdapterBaseRequest, ? extends AdapterBaseResponse>> simonUserSrvStrategyMap = new ConcurrentHashMap<>();

    public SimonUserSrvStrategyContext(Map<String, SimonUserSrvStrategy<? extends AdapterBaseRequest, ? extends AdapterBaseResponse>> simonUserSrvStrategys) {

        simonUserSrvStrategys.forEach((k, v) -> this.simonUserSrvStrategyMap.put(
                Objects.requireNonNull(AnnotationUtils.findAnnotation(v.getClass(), ApiName.class)).apiMehodName(), v));
    }

    public SimonUserSrvStrategy<? extends AdapterBaseRequest, ? extends AdapterBaseResponse> getRequestStrategy(String apiMethodName) {
        return simonUserSrvStrategyMap.get(apiMethodName);
    }
}
