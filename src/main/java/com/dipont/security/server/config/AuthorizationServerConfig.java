package com.dipont.security.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @author alex
 * @date 2019/8/20  9:08
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    @Resource
    DataSource dataSource;

    /**
     * 配置授权服务器的安全，意味着实际上是/oauth/token端点。
     * /oauth/authorize端点也应该是安全的
     * 默认的设置覆盖到了绝大多数需求，所以一般情况下你不需要做任何事情。
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()")
                .allowFormAuthenticationForClients();

    }
    /**
     * 配置ClientDetailsService
     * 注意，除非你在下面的configure(AuthorizationServerEndpointsConfigurer)中指定了一个AuthenticationManager，否则密码授权方式不可用。
     * 至少配置一个client，否则服务器将不会启动。
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.jdbc(dataSource)
//                .withClient("HpgSys")
//                .secret(encoder.encode("123456"))
//                .scopes("dipont")
//                .authorizedGrantTypes("authorization_code", "refresh_token")
//                .redirectUris("http://localhost:8081/login")
//                .accessTokenValiditySeconds(120*60)
//                .refreshTokenValiditySeconds(30*24*60*60).autoApprove(true)
//                .and().withClient("CRMSys")
//                .secret(encoder.encode("123456"))
//                .scopes("dipont")
//                .authorizedGrantTypes("authorization_code", "refresh_token")
//                .redirectUris("http://localhost:8082/login")
//                .accessTokenValiditySeconds(120*60)
//                .refreshTokenValiditySeconds(30*24*60*60).autoApprove(true)
        ;
    }

    /**
     * 该方法是用来配置Authorization Server endpoints的一些非安全特性的，比如token存储、token自定义、授权类型等等的
     * 默认情况下，你不需要做任何事情，除非你需要密码授权，那么在这种情况下你需要提供一个AuthenticationManager
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        super.configure(endpoints);
    }


}
