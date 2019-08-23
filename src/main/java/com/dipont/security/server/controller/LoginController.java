package com.dipont.security.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.security.PermitAll;


/**
 * @author alex
 * @date 2019/8/20  10:43
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/index")
    @ResponseBody
    @PermitAll
    public String index() {
        return "hello sso";
    }
}
