package com.dipont.security.server.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * @author alex
 * @date 2019/8/20  16:27
 */
@Getter
@Setter
public class SysClient {
    private String clientId;
    private String clientSecret;
    private String redirectUri;
}
