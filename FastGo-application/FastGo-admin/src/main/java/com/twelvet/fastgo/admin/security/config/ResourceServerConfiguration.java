package com.twelvet.fastgo.admin.security.config;


import com.twelvet.fastgo.admin.security.filter.LoginAuthenticationFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: Resoource安全配置
 */
@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    /**
     * 登录验证拦截
     */
    private final LoginAuthenticationFilter loginAuthenticationFilter;

    public ResourceServerConfiguration(LoginAuthenticationFilter loginAuthenticationFilter) {
        this.loginAuthenticationFilter = loginAuthenticationFilter;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                // 添加登录验证拦截
                .addFilterBefore(loginAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                // CRSF禁用，因为不使用session
                .csrf().disable()
                // 使用Token，取消Session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                // 设置访问权限
                .and().authorizeRequests()
                // 开放路径
                .antMatchers(
                        "/captcha.jpg"
                ).permitAll()
                // 除以上路径，所有路径开启鉴权
                .anyRequest().authenticated();
    }

}
