package com.quincy.spring.mapper;

import com.quincy.spring.domain.User;

public interface UserMapper {

    int getMatchCount(String userName, String password);

    User getUserByUserName(final String userName);

    void updateLoginInfo(User user);
}
