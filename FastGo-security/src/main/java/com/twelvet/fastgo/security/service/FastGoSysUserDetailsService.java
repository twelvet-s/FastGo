package com.twelvet.fastgo.security.service;

import com.twelvet.fastgo.security.pojo.FastGoSysUser;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 后台用户登录逻辑
 */
public interface FastGoSysUserDetailsService extends UserDetailsService {

    FastGoSysUser loadUserByAppIdAndBizUserId(String username);

}
