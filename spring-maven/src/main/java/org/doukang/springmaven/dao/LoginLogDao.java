package org.doukang.springmaven.dao;

import org.doukang.springmaven.domain.LoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LoginLogDao
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addLoginLog(LoginLog log)
    {
        String sqlString = "INSERT INTO t_login_log (user_id, ip, time) VALUES (?, ?, ?)";
        Object[] args = {log.getUserId(), log.getIp(), log.getTime()};
        jdbcTemplate.update(sqlString, args);
    }
}
