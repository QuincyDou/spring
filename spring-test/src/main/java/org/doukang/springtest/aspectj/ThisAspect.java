package org.doukang.springtest.aspectj;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.doukang.springtest.aop.advice.Waiter;

@Aspect
public class ThisAspect
{
    @AfterReturning("this(seller)")
    public void thisTest(Seller seller)
    {
        System.out.println("thisTest() executed!:" + seller.getClass().getName());
    }
}
