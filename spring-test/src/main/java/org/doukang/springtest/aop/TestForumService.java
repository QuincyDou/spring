package org.doukang.springtest.aop;

import java.lang.reflect.Proxy;

public class TestForumService
{

    public static void main(String[] args)
    {
        /*ForumService service = new ForumServiceImpl();
        PerformanceHandler handler = new PerformanceHandler(service);
        ForumService proxy = (ForumService) Proxy.newProxyInstance(
                service.getClass().getClassLoader(),
                service.getClass().getInterfaces(), handler);
        proxy.removeTopic(101);
        proxy.removeForum(1012);*/
        
        CglibProxy proxy = new CglibProxy();
        ForumServiceImpl service = (ForumServiceImpl) proxy
                .getProxy(ForumServiceImpl.class);
        service.removeTopic(101);
        service.removeForum(1012);
    }

}
