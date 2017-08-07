package org.doukang.springtest.aop.advisor;

import org.doukang.springtest.aop.ForumService;
import org.doukang.springtest.aop.Monitorable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBeans
{
    public static void main(String[] args)
    {
        String path = "org/doukang/springtest/aop/advisor/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(path);

        /*Waiter waiter = (Waiter) ctx.getBean("waiterProxy");
        Seller seller = (Seller) ctx.getBean("sellerProxy");
        waiter.greetTo("Quincy");
        waiter.serveTo("Quincy");
        seller.greetTo("Quincy");
        waiter.greetTo("Luohan");
        waiter.serveTo("Luohan");
        waiter.greetTo("Geson");
        WaiterDelegate wd = new WaiterDelegate();
        wd.setWaiter(waiter);
        wd.service("Quincy");*/

        /*ForumService forumService = (ForumService) ctx.getBean("forumProxy");
        forumService.removeTopic(101);
        forumService.removeForum(1012);
        Monitorable monitorable = (Monitorable) forumService;
        monitorable.setMonitorActive(true);
        forumService.removeTopic(101);
        forumService.removeForum(1012);*/

        Waiter waiter = (Waiter) ctx.getBean("waiter");
        Seller seller = (Seller) ctx.getBean("seller");
        waiter.greetTo("Quincy");
        waiter.serveTo("Quincy");
        seller.greetTo("Quincy");
    }
}
