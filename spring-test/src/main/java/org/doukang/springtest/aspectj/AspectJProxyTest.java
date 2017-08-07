package org.doukang.springtest.aspectj;

import org.doukang.springtest.aop.advice.NaiveWaiter;
import org.doukang.springtest.aop.advice.Waiter;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

public class AspectJProxyTest
{
    public static void main(String[] args)
    {
        Waiter waiter = new NaiveWaiter();
        AspectJProxyFactory factory = new AspectJProxyFactory();
        factory.setTarget(waiter);
        factory.addAspect(PreGreetingAspect.class);
        Waiter proxy = factory.getProxy();
        proxy.greetTo("Quincy");
        proxy.serveTo("Quincy");
    }
}
