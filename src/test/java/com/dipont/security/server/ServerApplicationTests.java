package com.dipont.security.server;

import com.dipont.security.server.domain.SysUser;
import com.dipont.security.server.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServerApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    UserService userService;

//    @Test
//    public void addUsers(){
//        SysUser user = new SysUser();
//        user.setUserName("cris");
//        user.setPassword("root");
//        userService.addUser(user);
//    }

}
