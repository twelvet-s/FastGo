package com.twelvet.fastgo.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenStore;


/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: OAuth2配置
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

//    /**
//     * 密码模式需要注入认证管理器
//     */
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private TokenStore tokenStore;
//
//    @Autowired
//    private AuthorizationServerTokenServices yamiTokenServices;
//
//    /**
//     * 增强成功获取token的信息
//     */
//    @Autowired
//    private TokenEnhancer tokenEnhancer;
//
//    /**
//     * 自定义用户认证逻辑,开启refresh_token需要用到
//     */
//    @Autowired
//    private UserDetailsService userDetailsService;
//
//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
//        endpoints
//                // 加入密码模式
//                .authenticationManager(authenticationManager)
//                // 使用redis储存token（切记：不要关了refresh_token运行，又开启，会导致没有refresh_token）
//                .tokenStore(tokenStore)
//                .tokenEnhancer(tokenEnhancer)
//                // refresh_token需要userDetailsService
//                .reuseRefreshTokens(false)
//                // 自定义登录逻辑
//                .userDetailsService(userDetailsService);
//        endpoints.tokenServices(yamiTokenServices);
//    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) {
        oauthServer
                // 开启/oauth/token_key验证端口无权限访问
                .tokenKeyAccess("permitAll()")
                // 开启/oauth/check_token验证端口认证权限访问
                .checkTokenAccess("isAuthenticated()");
    }

}
