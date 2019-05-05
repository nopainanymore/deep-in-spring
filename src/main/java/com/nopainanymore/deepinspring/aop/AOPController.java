package com.nopainanymore.deepinspring.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * deep-in-spring: AOPController
 *
 * @author NoPainAnymore
 * @date 2019-05-04 14:50
 */
@RestController
@RequestMapping("/aop")
@Slf4j
public class AOPController {


    @GetMapping("/hello")
    public String aop() {
        log.info("AOPController- aop: hello aop ");
        return "aop";
    }

}
