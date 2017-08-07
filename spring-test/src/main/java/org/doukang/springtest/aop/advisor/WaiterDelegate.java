package org.doukang.springtest.aop.advisor;

public class WaiterDelegate
{
    private Waiter waiter;
    
    public void setWaiter(Waiter waiter)
    {
        this.waiter = waiter;
    }
    
    public void service(String guestName)
    {
        waiter.greetTo(guestName);
        waiter.serveTo(guestName);
    }
}
