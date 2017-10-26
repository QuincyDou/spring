package com.quincy.spring.service;

import com.quincy.spring.domain.LoginLog;
import com.quincy.spring.domain.User;
import com.quincy.spring.mapper.LoginLogMapper;
import com.quincy.spring.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
    @Autowired
    private UserMapper userMapper;
    
    @Autowired
    private LoginLogMapper loginLogMapper;
    
    public boolean hasMatchUser(String userName, String password)
    {
        int matchCount = userMapper.getMatchCount(userName, password);
        return matchCount > 0;
    }
    
    public User getUserByUserName(String userName)
    {
        return userMapper.getUserByUserName(userName);
    }
    
    public void loginSuccess (User user)
    {
        LoginLog log = new LoginLog();
        log.setUserId(user.getUserId());
        log.setIp(user.getLastIP());
        log.setTime(user.getLastVisit());
        userMapper.updateLoginInfo(user);
        loginLogMapper.addLoginLog(log);
    }
}
