package com.simon.scaffold.user.annotation;

import java.lang.annotation.*;

/**
 * @author xiaochong.fan
 * @version 1.0
 * @date 2022/6/8 17:31
 * @description: 请求策略枚举
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ApiName {

    String apiMehodName() default "";
}
