package com.pl1111w.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Aspect
public class AspectLogging {

    @Pointcut(value = "@annotation(com.pl1111w.aop.annotations.Annotation)")
    //@Pointcut(value = "execution(public int logging())")
    public void declareAspect() {
    }

    @Before(value = "declareAspect()")
    public void LoggingAspectBefore(JoinPoint joinpoint) {
        String methodName = joinpoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinpoint.getArgs());
        System.out.println("The method " + methodName + " before:" + args);
    }

    @After(value = "declareAspect()")
    public void LoggingAspectAfter(JoinPoint joinpoint) {
        String methodName = joinpoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinpoint.getArgs());
        System.out.println("The method " + methodName + " after:" + args);
    }

    @AfterReturning(value = "declareAspect()", returning = "result")
    public void AfterReturning(JoinPoint joinpoint, Object result) {
        String methodName = joinpoint.getSignature().getName();
        System.out.println("The method " + methodName + " afterReturning " + result);
    }

    @AfterThrowing(value = "declareAspect()", throwing = "error")
    public void AfterThrowing(Throwable error) {
        System.out.println(error);
    }

    @Around(value = "execution(public int subLogging())")
    public int around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("已经记录下操作日志@Around 方法执行前");
        Object result = pjp.proceed();
        System.out.println("已经记录下操作日志@Around 方法执行后");
        return (Integer) result;
    }
}
