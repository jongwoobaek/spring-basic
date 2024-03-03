package com.springbasic.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeTraceAop {
    @Around("execution(* com.springbasic..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        System.out.println("Start: " + joinPoint.toLongString());

        try {
            return joinPoint.proceed();
        } finally {
            long endTime = System.currentTimeMillis();
            long timeMs = endTime - startTime;

            System.out.println("End: " + joinPoint.toLongString() + " " + timeMs + "ms");
        }
    }
}
