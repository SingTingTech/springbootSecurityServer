package com.dipont.security.server.controller;

import com.dipont.security.server.controller.request.UserRequest;
import com.dipont.security.server.domain.SysUser;
import com.dipont.security.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author alex
 * @date 2019/8/20  16:20
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/")
    public void addUser(UserRequest userRequest){
        SysUser user = new SysUser();
        user.setPassword(userRequest.getPassword());
        user.setUserName(userRequest.getUsername());
        userService.addUser(user);
    }

}
