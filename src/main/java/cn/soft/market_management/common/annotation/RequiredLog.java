package cn.soft.market_management.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//代表标注当前自定义注解在运行时生效
@Retention(RetentionPolicy.RUNTIME)
//代表当前注解可以标注方法
@Target(ElementType.METHOD)
public @interface RequiredLog {
    //代表当前自定义注解 可以传值 默认value值为空
    String value() default "";
}
