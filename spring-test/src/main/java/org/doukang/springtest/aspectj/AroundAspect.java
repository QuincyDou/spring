package org.doukang.springtest.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AroundAspect
{
    @Around("execution(* org..*.*Waiter.greetTo(..))")
    public void joinPointAccess(ProceedingJoinPoint pjp) throws Throwable
    {
        System.out.println("----joinPointAccess----");
        System.out.println("args[0]:" + pjp.getArgs()[0]);
        System.out.println("signature:" + pjp.getTarget().getClass());
        pjp.proceed();
        System.out.println("----joinPointAccess----");
    }
}
