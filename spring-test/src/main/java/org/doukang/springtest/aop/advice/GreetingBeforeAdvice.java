package org.doukang.springtest.aop.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class GreetingBeforeAdvice implements MethodBeforeAdvice
{
    public void before(Method method, Object[] args, Object obj)
            throws Throwable
    {
        System.out.println("Hello, Mr." + args[0]);
    }

}
