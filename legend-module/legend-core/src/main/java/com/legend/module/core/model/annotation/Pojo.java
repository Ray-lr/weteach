package com.legend.module.core.model.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Administrator
 * @date 2018/4/17
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface Pojo {

    Class entity() default Object.class;

    Class bo() default Object.class;

    Class vo() default Object.class;

    String[] ignoreProperties() default "";

}
