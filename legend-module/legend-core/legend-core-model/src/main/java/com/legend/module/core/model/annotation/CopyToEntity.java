package com.legend.module.core.model.annotation;

import com.legend.module.core.model.pojo.AbstractPojo;

import java.lang.annotation.*;

/**
 * @author Administrator
 * @date 2018/3/13
 */
@Target({ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface CopyToEntity {

    Class<? extends AbstractPojo> className() default AbstractPojo.class;
}
