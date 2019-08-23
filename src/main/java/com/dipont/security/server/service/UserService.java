package com.dipont.security.server.service;

import com.dipont.security.server.domain.SysUser;

/**
 * @author alex
 * @date 2019/8/20  10:08
 */
public interface UserService {
    SysUser getUserByName(String userName);
    void addUser(SysUser user);
}
