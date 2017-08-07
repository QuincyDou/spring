package org.doukang.springtest.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectTest
{
    public static Car initByDefaultCons() throws Throwable
    {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        
        System.out.println("current loader : " + loader);
        System.out.println("parent loader : " + loader.getParent());
        System.out.println("grandpa loader : " + loader.getParent().getParent());
        
        Class clazz = loader.loadClass("org.doukang.springtest.reflect.Car");
        
        Constructor cons = clazz.getDeclaredConstructor();
        Car car = (Car) cons.newInstance();
        
        Method setBrand = clazz.getDeclaredMethod("setBrand", String.class);
        setBrand.invoke(car, "大众CC");
        Method setColor = clazz.getDeclaredMethod("setColor", String.class);
        setColor.invoke(car, "绚丽黄");
        Method setMaxSpeed = clazz.getDeclaredMethod("setMaxSpeed", int.class);
        setMaxSpeed.invoke(car, 280);
        return car;
    }
    
    public static void main(String[] args) throws Throwable
    {
        Car car = initByDefaultCons();
        car.introduce();
    }
}
