package org.doukang.springtest.aop.advisor;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

public class GreetingDynamicPointcut extends DynamicMethodMatcherPointcut
{
    private static List<String> specialGuests = new ArrayList<String>();
    
    static
    {
        specialGuests.add("Geson");
        specialGuests.add("Hongyu");
    }

    public ClassFilter getClassFilter()
    {
        return new ClassFilter()
        {
            public boolean matches(Class<?> clazz)
            {
                return Waiter.class.isAssignableFrom(clazz);
            }
        };
    }
    
    public boolean matches(Method method, Class clazz)
    {
        System.out.println("调用Matches(method, clazz)" + clazz.getName() +
                "." + method.getName() + "做静态检查");
        return "greetTo".equals(method.getName());
    }
    
    public boolean matches(Method method, Class<?> targetClass, Object[] args)
    {
        System.out.println("调用Matches(method, clazz, args)" + targetClass.getName()
                + "." + method.getName() + "做动态检查");
        return specialGuests.contains((String) args[0]);
    }

}
