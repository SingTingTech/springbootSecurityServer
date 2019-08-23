package com.dipont.security.server.controller.request;

import lombok.Getter;
import lombok.Setter;

/**
 * @author alex
 * @date 2019/8/20  16:22
 */
@Getter
@Setter
public class UserRequest {

    private String username;
    private String password;
}
