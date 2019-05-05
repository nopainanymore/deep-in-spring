package com.nopainanymore.deepinspring.aop;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * deep-in-spring: Aspect
 *
 * @author NoPainAnymore
 * @date 2019-05-04 14:48
 */
@org.aspectj.lang.annotation.Aspect
@Component
@Slf4j
public class Aspect {

    private static final Gson gson = new Gson();

    @Pointcut("execution(public * com.nopainanymore.deepinspring.aop.AOPController.*(..)))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        log.info("Aspect- doBefore:{}", gson.toJson(requestAttributes.getRequest().getRequestedSessionId()));
        log.info("Aspect- doBefore:{}", joinPoint.toShortString());
        log.info("Aspect- doBefore- before the pointCut");
    }

    @After("pointCut()")
    public void doAfter() {
        log.info("Aspect- doAfter- after the pointCut");
    }

    @AfterReturning(pointcut = "pointCut()", returning = "ret")
    public void doAfterReturning(String ret) {
        log.info("Aspect- doAfterReturning:{}", ret);
    }


    @AfterThrowing(pointcut = "pointCut()")
    public void doAfterThrowing() {
        log.info("Aspect- doAfterThrowing- Exception");
    }

    @Around("pointCut()")
    public String doAround(ProceedingJoinPoint proceedingJoinPoint) {
        log.info("Aspect- doAround- start");
        try {
            return (String) proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            log.info("Aspect- doAround- end");
            return throwable.getMessage();
        }
    }
}
