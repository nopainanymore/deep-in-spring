package com.nopainanymore.deepinspring.resolver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * deep-in-spring: UserConfig
 *
 * @author NoPainAnymore
 * @date 2019-05-14 23:05
 */
@Configuration
@Slf4j
public class UserConfig implements WebMvcConfigurer {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        log.info("UserConfig- addArgumentResolvers- initial resolver");
        resolvers.add(new UserArgumentResolver());
    }
}
