package org.doukang.springtest.aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class EnableSellerAspect
{
    @DeclareParents(value = "org.doukang.springtest.aop.advice.NaiveWaiter",
            defaultImpl = SmartSeller.class)
    public static Seller seller;
}
