package com.linxin.SpringBootRest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    // we have to mention return type, class-name.method name(args)
    // @Before("execution(* *.*(..))") // all return types, all classes, all methods and any arguments
    @Before("execution(* com.linxin.SpringBootRest.service.JobService.getJob(..)) " +
            "|| execution(* com.linxin.SpringBootRest.service.JobService.updateJob(..))")
    public void logMethodCall(JoinPoint jp) {
        LOGGER.info(jp.getSignature().getName() + " method called");
    }

    @After("execution(* com.linxin.SpringBootRest.service.JobService.getJob(..)) " +
            "|| execution(* com.linxin.SpringBootRest.service.JobService.updateJob(..))")
    public void logMethodExecuted(JoinPoint jp) {
        LOGGER.info(jp.getSignature().getName() + " method executed");
    }

    // call when has some errors
    @AfterThrowing("execution(* com.linxin.SpringBootRest.service.JobService.getJob(..)) " +
            "|| execution(* com.linxin.SpringBootRest.service.JobService.updateJob(..))")
    public void logMethodCrash(JoinPoint jp) {
        LOGGER.info(jp.getSignature().getName() + " method has some issues");
    }

    // call when has no errors
    @AfterReturning("execution(* com.linxin.SpringBootRest.service.JobService.getJob(..)) " +
            "|| execution(* com.linxin.SpringBootRest.service.JobService.updateJob(..))")
    public void logMethodExecutedSuccess(JoinPoint jp) {
        LOGGER.info(jp.getSignature().getName() + " method executed successfully");
    }

}
