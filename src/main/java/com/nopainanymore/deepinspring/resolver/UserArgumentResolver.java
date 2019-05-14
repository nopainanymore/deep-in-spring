package com.nopainanymore.deepinspring.resolver;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

/**
 * deep-in-spring: UserArgumentResolver
 *
 * @author NoPainAnymore
 * @date 2019-05-14 22:55
 */
@Component
@Slf4j
public class UserArgumentResolver implements HandlerMethodArgumentResolver {

    private static final Gson gson = new Gson();

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.hasParameterAnnotation(LoginUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        Optional<User> userOptional = Optional.ofNullable((User) nativeWebRequest.getAttribute("user", RequestAttributes.SCOPE_SESSION));
        User user = userOptional.orElseGet(() -> {
            log.info("UserArgumentResolver- resolveArgument- user is null, set user");
            User add = User.builder().userId("1").userName("noPainAnyMore").build();
            HttpServletRequest httpServletRequest = (HttpServletRequest) nativeWebRequest.getNativeRequest();
            HttpSession session = httpServletRequest.getSession();
            session.setAttribute("user", add);
            return add;
        });
        log.info("UserArgumentResolver- resolveArgument- user{}", gson.toJson(user));
        return user;
    }
}
