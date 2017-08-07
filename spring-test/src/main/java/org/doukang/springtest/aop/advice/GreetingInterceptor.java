package org.doukang.springtest.aop.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class GreetingInterceptor implements MethodInterceptor
{
    public Object invoke(MethodInvocation method) throws Throwable
    {
        Object[] args = method.getArguments();
        String name = (String) args[0];
        
        System.out.println("How are you! Mr." + name);
        Object object = method.proceed();
        System.out.println("Please enjoy yourself!");
        return object;
    }

}
