package com.cloudofgoods.auth.configarations.security;

import com.cloudofgoods.auth.entity.Permission;
import com.cloudofgoods.auth.entity.Role;
import com.cloudofgoods.auth.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class CustomTokenEnhancer implements TokenEnhancer {
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
        log.info("Log::CustomTokenEnhancer.enhance ");
        final Map<String, Object> additionalInfo = new HashMap<>();
        User user = (User) oAuth2Authentication.getPrincipal();
        List<Integer> roles = user.getRoles().stream().map(Role::getId).collect(Collectors.toList());

        List<List<Permission>> permissions = user.getRoles().stream().map(Role::getPermissions).collect(Collectors.toList());
        List<Integer> role_and_permission = permissions.stream().flatMap(Collection::stream).map(Permission::getId).collect(Collectors.toList());
        List<Integer> collect = Stream.concat(roles.stream(), role_and_permission.stream()).collect(Collectors.toList());
        String stringPermissions = String.join(", ", collect.toString());
        String BasicBase64formatPermissions = Base64.getEncoder().encodeToString(stringPermissions.getBytes());


        additionalInfo.put("authorize", BasicBase64formatPermissions);
        ((DefaultOAuth2AccessToken) oAuth2AccessToken).setAdditionalInformation(additionalInfo);
        return oAuth2AccessToken;
    }
}