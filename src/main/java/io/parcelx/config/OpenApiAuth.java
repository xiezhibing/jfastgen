package io.parcelx.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * TODO 开放API
 * @author Zhibing.Xie
 * @date 2017年9月1日 下午4:34:51
 * @version <b>1.0.0</b>
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface OpenApiAuth {

}