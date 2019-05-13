package com.nopainanymore.deepinspring.application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


/**
 * deep-in-spring: ApplicationUtil
 *
 * @author NoPainAnymore
 * @date 2019-05-11 22:19
 */
@Component
@Slf4j
public class ApplicationUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("------ApplicationUtil setApplicationContext-------");
        ApplicationUtil.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    @SuppressWarnings("unchecked")
    public static <T> T getBeanByClass(Class<T> clazz) throws BeansException {
        try {
            return (T) applicationContext.getBean(upperToLowerCamelCase(clazz.getSimpleName()));
        } catch (NoSuchBeanDefinitionException e) {
            if (log.isDebugEnabled()) {
                log.debug("ApplicationUtil- getBeanByClass", e);
            }
            log.info("ApplicationUtil- getBeanByClass- NoSuchBeanDefinitionException:{}", e.getMessage());
            return null;
        }
    }

    private static String upperToLowerCamelCase(String upperCamelCase) {
        char[] cs = upperCamelCase.toCharArray();
        // 类名首字母小写
        cs[0] += 32;
        return String.valueOf(cs);
    }

    public static Object getBeanBySimpleName(String clazzSimpleName) {
        try {
            return applicationContext.getBean(upperToLowerCamelCase(clazzSimpleName));
        } catch (NoSuchBeanDefinitionException e) {
            if (log.isDebugEnabled()) {
                log.debug("ApplicationUtil- getBeanByClass", e);
            }
            log.info("ApplicationUtil- getBeanByClass- clazzSimpleName:{} NoSuchBeanDefinitionException:{}", clazzSimpleName, e.getMessage());
            return null;
        }
    }

    public static boolean containsBean(Class clazz) {
        return applicationContext.containsBean(upperToLowerCamelCase(clazz.getSimpleName()));
    }

    public static boolean containsBean(String simpleName) {
        return applicationContext.containsBean(upperToLowerCamelCase(simpleName));
    }

    public static boolean isSingleton(String simpleName) throws NoSuchBeanDefinitionException {
        return applicationContext.isSingleton(upperToLowerCamelCase(simpleName));
    }
}