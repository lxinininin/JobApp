package com.linxin.SpringBootRest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
public class ValidationAspect {

    private static final Logger LOGGER = Logger.getLogger(ValidationAspect.class.getName());

    @Around("execution(* com.linxin.SpringBootRest.service.JobService.getJob(..)) && args(postId)")
    // the postId as an argument pass to getJob() will also pass to the same name argument postId below
    public Object validateAndUpdate(ProceedingJoinPoint joinPoint, int postId) throws Throwable {
        if (postId < 0) {
            LOGGER.info("PostId is negative, updating it");
            postId = -postId;
            LOGGER.info("new value is " + postId);
        }

        Object obj = joinPoint.proceed(new Object[]{postId}); // we have to pass new postId

        return obj;
    }

}
