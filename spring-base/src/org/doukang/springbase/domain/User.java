package org.doukang.springbase.domain;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable
{
    private static final long serialVersionUID = 1L;

    private int userId;

    private String userName;

    private String password;

    private Date lastVisit;

    private String lastIP;

    public int getUserId()
    {
        return userId;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public Date getLastVisit()
    {
        return lastVisit;
    }

    public void setLastVisit(Date lastVisit)
    {
        this.lastVisit = lastVisit;
    }

    public String getLastIP()
    {
        return lastIP;
    }

    public void setLastIP(String lastIP)
    {
        this.lastIP = lastIP;
    }
}
