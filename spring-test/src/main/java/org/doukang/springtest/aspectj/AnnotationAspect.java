package org.doukang.springtest.aspectj;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AnnotationAspect
{
    @AfterReturning(
            value = "@annotation(org.doukang.springtest.aspectj.NeedTest)",
            returning = "retVal")
    public void needTestFun(int retVal)
    {
        System.out.println("needTestFun() executed! result = " + retVal);
    }
}
