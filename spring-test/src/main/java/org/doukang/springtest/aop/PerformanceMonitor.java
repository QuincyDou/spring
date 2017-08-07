package org.doukang.springtest.aop;

public class PerformanceMonitor
{
    private static ThreadLocal<MethodPerformance> performanceRecord =
            new ThreadLocal<MethodPerformance>();

    public static void begin(String method)
    {
        System.out.println("begin monitor...");
        MethodPerformance mp = new MethodPerformance(method);
        performanceRecord.set(mp);
    }

    public static void end()
    {
        MethodPerformance mp = performanceRecord.get();
        System.out.println("end monitor...");
        mp.printPerformance();
    }
}
