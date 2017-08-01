package org.doukang.springbase.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.doukang.springbase.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int getMatchCount(String userName, String password)
    {
        String sqlStr = "SELECT count(*) FROM t_user WHERE user_name = ? AND password = ?";
        return jdbcTemplate.queryForInt(sqlStr, new Object[] {userName, password});
    }

    public User getUserByUserName(final String userName)
    {
        String sqlStr = "SELECT user_id, user_name FROM t_user WHERE user_name = ?";
        final User user = new User();
        jdbcTemplate.query(sqlStr, new Object[] {userName}, new RowCallbackHandler()
        {
            public void processRow(ResultSet rs) throws SQLException
            {
                user.setUserId(rs.getInt(1));
                user.setUserName(rs.getString(2));
            }
        });
        return user;
    }

    public void updateLoginInfo(User user)
    {
        String sqlStr = "UPDATE t_user SET last_visit = ?, last_ip = ? WHERE user_id = ?";
        jdbcTemplate.update(sqlStr, new Object[] {user.getLastVisit(), user.getLastIP(), user.getUserId()});
    }
}
