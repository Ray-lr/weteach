package com.legend.module.core.web.aspect;

import com.legend.module.core.model.annotation.Pojo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author Administrator
 * @date 2018/4/19
 */
@Aspect
@Component
public class PojoAspect {

    @Pointcut("@annotation(com.legend.module.core.model.annotation.Pojo)")
    public void annotationPointCut(){

    }

    @Before("annotationPointCut()")
    public void before(JoinPoint joinPoint){
        MethodSignature sign = (MethodSignature)joinPoint.getSignature();
        Method method = sign.getMethod();
        Pojo pojo = method.getAnnotation(Pojo.class);
    }
}
