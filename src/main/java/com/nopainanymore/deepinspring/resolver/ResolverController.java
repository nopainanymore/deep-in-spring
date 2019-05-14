package com.nopainanymore.deepinspring.resolver;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * deep-in-spring: ResolverController
 *
 * @author NoPainAnymore
 * @date 2019-05-14 22:56
 */
@RestController
@RequestMapping("/resolver")
@Slf4j
public class ResolverController {

    private static final Gson gson = new Gson();

    @GetMapping("/user")
    public String user(@LoginUser User user) {
        log.info("ResolverController- user:{}", gson.toJson(user));
        return user.getUserName();
    }
}
