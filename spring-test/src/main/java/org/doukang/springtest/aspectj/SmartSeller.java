package org.doukang.springtest.aspectj;

public class SmartSeller implements Seller
{
    public void sell(String goods, String guest)
    {
        System.out.println("sell " + goods + " to " + guest);
    }
}
