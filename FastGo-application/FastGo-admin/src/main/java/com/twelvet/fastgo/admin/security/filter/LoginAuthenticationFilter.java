package com.twelvet.fastgo.admin.security.filter;


import com.twelvet.fastgo.security.service.FastGoSysUserDetailsService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 登录拦截验证
 */
@Component
public class LoginAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private final FastGoSysUserDetailsService userDetailsService;

    private final PasswordEncoder passwordEncoder;

    public LoginAuthenticationFilter(FastGoSysUserDetailsService userDetailsService,
                                     PasswordEncoder passwordEncoder,
                                     AuthenticationManager authenticationManager,
                                     AuthenticationSuccessHandler successHandler,
                                     AuthenticationFailureHandler failureHandler) {
        super("/login");
        super.setAuthenticationManager(authenticationManager);
        super.setAuthenticationSuccessHandler(successHandler);
        super.setAuthenticationFailureHandler(failureHandler);
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * 用户登录逻辑
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @return
     * @throws AuthenticationException
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {
        return null;
    }


}
