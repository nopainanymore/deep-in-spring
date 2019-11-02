package com.nopainanymore.deepinspring.postoperation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

/**
 * deep-in-spring: PostOperationComponent
 *
 * @author nopainanymore
 * @version 2019-11-02 09:46
 */
@Component
@Slf4j
public class PostOperationComponent implements InitializingBean, ApplicationRunner, CommandLineRunner {

    public PostOperationComponent() throws InterruptedException {
        log.info("PostOperationComponent- PostOperationComponent- constructor");
        TimeUnit.SECONDS.sleep(1);
    }

    @PostConstruct
    private void postConstruct() throws InterruptedException {
        log.info("PostOperationComponent- postConstruct- postConstruct");
        TimeUnit.SECONDS.sleep(1);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("PostOperationComponent- afterPropertiesSet- initializingBean");
        TimeUnit.SECONDS.sleep(1);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("PostOperationComponent- run- ApplicationRunner");
        TimeUnit.SECONDS.sleep(1);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("PostOperationComponent- run- CommandLineRunner");
        TimeUnit.SECONDS.sleep(1);
    }
}
