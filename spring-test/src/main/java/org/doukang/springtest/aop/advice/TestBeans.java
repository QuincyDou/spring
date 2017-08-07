package org.doukang.springtest.aop.advice;

import java.sql.SQLException;

import org.doukang.springtest.aop.ForumService;
import org.doukang.springtest.aop.Monitorable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBeans
{
    public static void main(String[] args) throws SQLException
    {
        String path = "org/doukang/springtest/aop/advice/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(path);
        
        /*Waiter waiterProxy = (Waiter) ctx.getBean("waiterProxy");
        waiterProxy.greetTo("Quincy");
        waiterProxy.serveTo("Quincy");*/
        
        /*ExceptionService exProxy = (ExceptionService) ctx.getBean("exProxy");
        exProxy.throwRuntimeExp();
        // or
        exProxy.throwSQLExp();*/
        
        ForumService forumProxy = (ForumService) ctx.getBean("forumProxy");
        forumProxy.removeTopic(101);
        forumProxy.removeForum(1012);
        Monitorable monitorable = (Monitorable) forumProxy;
        monitorable.setMonitorActive(true);
        forumProxy.removeTopic(101);
        forumProxy.removeForum(1012);
    }
}
