package com.nopainanymore.deepinspring.resolver;

import java.lang.annotation.*;

/**
 * deep-in-spring: LoginUser
 *
 * @author NoPainAnymore
 * @date 2019-05-14 22:56
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LoginUser {
}
