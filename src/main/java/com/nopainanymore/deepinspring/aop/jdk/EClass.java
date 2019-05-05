package com.nopainanymore.deepinspring.aop.jdk;

import lombok.extern.slf4j.Slf4j;

/**
 * deep-in-spring: EClass
 *
 * @author NoPainAnymore
 * @date 2019-05-04 16:13
 */
@Slf4j
public class EClass implements ExInterface {

    @Override
    public void execute() {
        log.info("EClass- execute- execute method");
    }

    public void noProxy(){
        log.info("EClass- noProxy- normal");
    }
}
