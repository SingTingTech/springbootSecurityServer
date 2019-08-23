package com.dipont.security.server.service.impl;

import com.dipont.security.server.dao.UserDao;
import com.dipont.security.server.domain.SysUser;
import com.dipont.security.server.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author alex
 * @date 2019/8/20  10:11
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public SysUser getUserByName(String userName) {
        return userDao.getUserByName(userName);
    }

    @Override
    public void addUser(SysUser user) {
        userDao.saveUser(user);
    }
}
