package com.dipont.security.server.controller;

import com.dipont.security.server.controller.request.ClientRequest;
import com.dipont.security.server.domain.SysClient;
import com.dipont.security.server.service.ClientService;
import com.mysql.cj.xdevapi.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.config.annotation.builders.ClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.builders.JdbcClientDetailsServiceBuilder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.HashMap;

/**
 * @author alex
 * @date 2019/8/20  16:24
 */
@RestController
@RequestMapping("client")
public class ClientController {
    @Autowired
    ClientService clientService;

    @PostMapping("/")
    public void addClient(ClientRequest request){
        SysClient client = new SysClient();
        client.setClientId(request.getClientId());
        client.setClientSecret(request.getClientSecret());
        client.setRedirectUri(request.getRedirectUri());
        clientService.addClient(client);

    }
}
