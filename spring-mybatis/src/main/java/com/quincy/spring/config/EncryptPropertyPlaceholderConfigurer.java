package com.quincy.spring.config;

import com.quincy.spring.util.DESUtils;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class EncryptPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer
{
    private final String[] encryptPropNames = {"username", "password"};

    @Override
    protected String convertProperty(String propertyName, String propertyValue)
    {
        if (isEncryptProp(propertyName))
        {
            return DESUtils.getDecryptString(propertyValue);
        }
        else
        {
            return propertyValue;
        }
    }
    
    private boolean isEncryptProp(String propertyName)
    {
        for (String encryptPropName : encryptPropNames)
        {
            if (encryptPropName.equals(propertyName))
            {
                return true;
            }
        }
        return false;
    }
}
