package org.doukang.springtest.aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class PreGreetingAspect
{
    @Before("execution(* greetTo(..)) && args(name)")
    public void beforeGreeting(String name)
    {
        System.out.println("How are you!" + name);
    }
}
