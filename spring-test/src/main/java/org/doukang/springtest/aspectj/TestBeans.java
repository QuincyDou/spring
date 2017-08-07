package org.doukang.springtest.aspectj;

import org.doukang.springtest.aop.advice.Waiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBeans
{
    public static void main(String[] args)
    {
        String path = "org/doukang/springtest/aspectj/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(path);
        
        Waiter waiter = (Waiter) ctx.getBean("waiter");
        waiter.greetTo("Quincy");
        waiter.serveTo("Quincy");
        ((Seller) waiter).sell("Shoots", "Quincy");
        Waiter naughtyWaiter = (Waiter) ctx.getBean("naughtyWaiter");
        naughtyWaiter.greetTo("Geson");
        naughtyWaiter.serveTo("Geson");
    }
}
