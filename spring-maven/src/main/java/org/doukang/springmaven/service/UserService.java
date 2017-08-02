package org.doukang.springmaven.service;

import org.doukang.springmaven.dao.LoginLogDao;
import org.doukang.springmaven.dao.UserDao;
import org.doukang.springmaven.domain.LoginLog;
import org.doukang.springmaven.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
    @Autowired
    private UserDao userDao;
    
    @Autowired
    private LoginLogDao loginLogDao;
    
    public boolean hasMatchUser(String userName, String password)
    {
        int matchCount = userDao.getMatchCount(userName, password);
        return matchCount > 0;
    }
    
    public User getUserByUserName(String userName)
    {
        return userDao.getUserByUserName(userName);
    }
    
    public void loginSuccess (User user)
    {
        LoginLog log = new LoginLog();
        log.setUserId(user.getUserId());
        log.setIp(user.getLastIP());
        log.setTime(user.getLastVisit());
        userDao.updateLoginInfo(user);
        loginLogDao.addLoginLog(log);
    }
}
