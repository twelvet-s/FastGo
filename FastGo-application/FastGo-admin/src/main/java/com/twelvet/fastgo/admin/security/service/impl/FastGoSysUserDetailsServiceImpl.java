package com.twelvet.fastgo.admin.security.service.impl;

import com.twelvet.fastgo.security.pojo.FastGoSysUser;
import com.twelvet.fastgo.security.service.FastGoSysUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 自定义用户登录逻辑
 */
@Service
public class FastGoSysUserDetailsServiceImpl implements FastGoSysUserDetailsService {
    @Override
    public FastGoSysUser loadUserByAppIdAndBizUserId(String username) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
