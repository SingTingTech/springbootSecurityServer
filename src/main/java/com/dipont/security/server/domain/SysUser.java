package com.dipont.security.server.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author alex
 * @date 2019/8/20  10:09
 */
@Getter
@Setter
@ToString
public class SysUser {
    private String userName;
    private String password;

    public void encryptPassword() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        this.password = encoder.encode(password);
    }
}
