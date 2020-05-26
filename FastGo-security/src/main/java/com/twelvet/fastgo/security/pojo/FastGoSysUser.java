package com.twelvet.fastgo.security.pojo;

import jdk.nashorn.internal.objects.annotations.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.Collections;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 登录用户实体
 */
public class FastGoSysUser extends User {

    /**
     * 用户ID
     */
    private String userId;

    private String bizUserId;

    private String pic;

    private String name;

    private boolean debugger;

    public FastGoSysUser(String userId, String bizUserId, Integer appId, boolean enabled) {
        super(appId + ":" + bizUserId, "", enabled,true, true, true , Collections.emptyList());
        this.userId = userId;
        this.bizUserId = bizUserId;
    }

}
