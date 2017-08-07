package org.doukang.springtest.aop.advice;

public class NaiveWaiter implements Waiter
{
    public void greetTo(String name)
    {
        System.out.println("greet to " + name);
    }

    public int serveTo(String name)
    {
        System.out.println("serve to " + name);
        return 0;
    }

}
