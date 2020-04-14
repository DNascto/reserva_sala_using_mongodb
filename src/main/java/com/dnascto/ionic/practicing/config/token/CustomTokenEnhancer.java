package com.dnascto.ionic.practicing.config.token;

import com.dnascto.ionic.practicing.security.UserSystem;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

public class CustomTokenEnhancer implements TokenEnhancer {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        UserSystem userSystem = (UserSystem) authentication.getPrincipal();

        Map<String, Object> addInfo = new HashMap<>();
            addInfo.put("accessLevel", userSystem.getUsers().getAccessLevel());
            addInfo.put("id", userSystem.getUsers().getId());
            addInfo.put("name", userSystem.getUsers().getName());

        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(addInfo);

        return accessToken;
    }
}
