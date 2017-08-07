package org.doukang.springtest.aop.advice;

import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

public class TestProxyFactory
{
    public static void main(String[] args)
    {
        Waiter waiter = new NaiveWaiter();
        BeforeAdvice before = new GreetingBeforeAdvice();
        
        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(waiter);
        factory.addAdvice(before);
        
        Waiter proxy = (Waiter) factory.getProxy();
        proxy.greetTo("Quincy");
        proxy.serveTo("Quincy");
    }
}
