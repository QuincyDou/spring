package org.doukang.springtest.aop.advice;

import org.aopalliance.intercept.MethodInvocation;
import org.doukang.springtest.aop.Monitorable;
import org.doukang.springtest.aop.PerformanceMonitor;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

public class ControllablePerformanceMonitor
            extends DelegatingIntroductionInterceptor implements Monitorable
{
    private ThreadLocal<Boolean> MonitorStatusMap = new ThreadLocal<Boolean>();

    public void setMonitorActive(boolean active)
    {
        MonitorStatusMap.set(active);
    }

    public Object invoke(MethodInvocation method) throws Throwable
    {
        Object obj = null;
        if (MonitorStatusMap.get() != null && MonitorStatusMap.get())
        {
            PerformanceMonitor.begin(method.getClass().getName() + "."
                    + method.getMethod().getName());
            obj = super.invoke(method);
            PerformanceMonitor.end();
        }
        else
        {
            obj = super.invoke(method);
        }
        return obj;
    }
}
