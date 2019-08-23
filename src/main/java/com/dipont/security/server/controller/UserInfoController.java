package com.dipont.security.server.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author alex
 * @date 2019/8/20  11:09
 */
@RestController
public class UserInfoController {

    @RequestMapping("/user-info")
    public Principal user(Principal principal) {
        System.out.println(principal);
        return principal;
    }
}
