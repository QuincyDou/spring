package org.doukang.springtest.aop;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor
{
    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class clazz)
    {
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    public Object intercept(Object obj, Method method, Object[] args,
            MethodProxy methodProxy) throws Throwable
    {
        PerformanceMonitor.begin(obj.getClass().getName() + "."
                + method.getName());
        Object object = methodProxy.invokeSuper(obj, args);
        PerformanceMonitor.end();
        return object;
    }

}
