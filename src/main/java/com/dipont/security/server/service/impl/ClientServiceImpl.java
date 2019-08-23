package com.dipont.security.server.service.impl;

import com.dipont.security.server.domain.SysClient;
import com.dipont.security.server.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

import java.util.HashSet;

/**
 * @author alex
 * @date 2019/8/20  16:26
 */
@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addClient(SysClient client) {




        jdbcTemplate.update("insert into oauth_client_details(client_id, resource_ids, " +
                        "client_secret, scope," +
                        "authorized_grant_types, web_server_redirect_uri," +
                        "authorities,access_token_validity," +
                        "refresh_token_validity, additional_information, " +
                        "autoapprove)" +
                        " value (?,?,?,?,?,?,?,?,?,?,?)",
                        client.getClientId(),"",
                        encoder.encode(client.getClientSecret()), "dipont",
                        "authorization_code,refresh_token",client.getRedirectUri(),
                        "",7200,
                        2592000,"",
                        "dipont");
    }
}
