package com.twelvet.fastgo.admin.security;

import com.twelvet.fastgo.security.pojo.FastGoSysUser;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: Token增强
 */
@Component
public class SysTokenEnhancer implements TokenEnhancer {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
        final Map<String, Object> additionalInfo = new HashMap<>(3);
        FastGoSysUser FastGoSysUser = (FastGoSysUser) oAuth2Authentication.getUserAuthentication().getPrincipal();
        /*additionalInfo.put("userId", FastGoSysUser.getUserId());*/
        additionalInfo.put("authorities", FastGoSysUser.getAuthorities());
        ((DefaultOAuth2AccessToken) oAuth2AccessToken).setAdditionalInformation(additionalInfo);
        return oAuth2AccessToken;
    }

}
