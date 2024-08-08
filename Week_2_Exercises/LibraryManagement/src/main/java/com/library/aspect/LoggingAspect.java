package com.library.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Around("execution(* com.library.service.*.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startExecution  = System.currentTimeMillis();
        
        Object proceeding= joinPoint.proceed();
        
        long et = System.currentTimeMillis() - startExecution;
        
        System.out.println(joinPoint.getSignature() + " executed in " + et + "ms");
        
        return proceeding;
    }
}
