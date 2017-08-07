package org.doukang.springtest.aspectj;

import org.doukang.springtest.aop.advice.Waiter;

public class NaughtyWaiter implements Waiter
{
    public void greetTo(String name)
    {
        System.out.println("better greet to " + name);
    }

    @NeedTest
    public int serveTo(String name)
    {
        System.out.println("better serve to " + name);
        return 10;
    }
}
