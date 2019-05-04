package com.nopainanymore.deepinspring.AOP;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

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

    @Pointcut("execution(public * com.nopainanymore.deepinspring.AOP.AOPController.*(..)))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void doBefore() {
        log.info("Aspect- doBefore- before the pointCut");
    }

    @After("pointCut()")
    public void doAfter() {
        log.info("Aspect- doAfter- after the pointCut");

    }


}
