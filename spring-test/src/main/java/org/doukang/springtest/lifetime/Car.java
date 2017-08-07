package org.doukang.springtest.lifetime;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Car implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean
{
    private String brand;
    
    private String color;
    
    private int maxSpeed;
    
    private BeanFactory beanFactory;
    
    private String beanName;
    
    public void destroy() throws Exception
    {
        // TODO Auto-generated method stub
        
    }

    public void afterPropertiesSet() throws Exception
    {
        // TODO Auto-generated method stub
        
    }

    public void setBeanName(String arg0)
    {
        // TODO Auto-generated method stub
        
    }

    public void setBeanFactory(BeanFactory arg0) throws BeansException
    {
        // TODO Auto-generated method stub
        
    }

}
