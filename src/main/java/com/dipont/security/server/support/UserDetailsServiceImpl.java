package com.dipont.security.server.support;

import com.dipont.security.server.domain.SysUser;
import com.dipont.security.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * @author alex
 * @date 2019/8/20  10:03
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final
    UserService userService;

    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        SysUser user = userService.getUserByName(userName);
        List<GrantedAuthority> authorities = new LinkedList<>();
        authorities.add(new SimpleGrantedAuthority("USER"));
        return new User(user.getUserName(),user.getPassword(),authorities);
    }
}
