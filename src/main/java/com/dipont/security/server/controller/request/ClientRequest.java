package com.dipont.security.server.controller.request;

import lombok.Getter;
import lombok.Setter;

/**
 * @author alex
 * @date 2019/8/20  17:14
 */
@Getter
@Setter
public class ClientRequest {
    private String clientId;
    private String clientSecret;
    private String redirectUri;
}
