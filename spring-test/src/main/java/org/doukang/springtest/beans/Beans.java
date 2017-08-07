package org.doukang.springtest.beans;

import org.doukang.springtest.reflect.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans
{
    @Bean(name = "car")
    public Car buildCar()
    {
        Car car = new Car();
        car.setBrand("大众CC");
        car.setColor("绚丽黄");
        car.setMaxSpeed(280);
        return car;
    }
}
