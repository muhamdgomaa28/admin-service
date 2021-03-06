//package com.example.demo.Security;
//
//import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
//import org.springframework.security.oauth2.common.OAuth2AccessToken;
//import org.springframework.security.oauth2.provider.OAuth2Authentication;
//import org.springframework.security.oauth2.provider.token.TokenEnhancer;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * Created by ahmed mar3y on 04/02/2018.
// */
//public class CustomTokenEnhancer implements TokenEnhancer {
//
//    @Override
//    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
//        User user = (User) authentication.getPrincipal();
//        final Map<String, Object> additionalInfo = new HashMap<>();
//
//        additionalInfo.put("id", user.getId());
//        additionalInfo.put("authorities", user.getAuthorities());
//
//        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
//
//        return accessToken;
//    }
//
//}