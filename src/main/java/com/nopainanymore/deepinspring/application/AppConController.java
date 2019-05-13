package com.nopainanymore.deepinspring.application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * deep-in-spring: AppConController
 *
 * @author NoPainAnymore
 * @date 2019-05-13 21:45
 */
@RestController
@RequestMapping("/appCon")
@Slf4j
public class AppConController {

    @GetMapping("/getBean")
    public String getService() {
        AppConService appConService = ApplicationUtil.getBeanByClass(AppConService.class);
        log.info("AppConController- getService:{}", appConService);
        return appConService.getClass().getSimpleName();
    }

}
