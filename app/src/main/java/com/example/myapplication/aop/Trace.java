package com.example.myapplication.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author ly-zhangty
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Trace {
    // 是否在方法前加，默认为true
    boolean isBefore() default true;

    // 自定义事件
    String traceId();

    // 备用字段 注意使用可变数组传递值形式为： key=value
    String[] reserve() default "";
}
