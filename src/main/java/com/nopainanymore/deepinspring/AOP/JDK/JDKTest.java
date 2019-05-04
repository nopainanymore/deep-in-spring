package com.nopainanymore.deepinspring.AOP.JDK;

/**
 * deep-in-spring: JDKTest
 *
 * @author NoPainAnymore
 * @date 2019-05-04 16:48
 */
public class JDKTest {

    public static void main(String[] args) {
        EClass eClass = new EClass();
        JDKProxy proxy = new JDKProxy(eClass);
        proxy.createProxy().execute();

    }
}
