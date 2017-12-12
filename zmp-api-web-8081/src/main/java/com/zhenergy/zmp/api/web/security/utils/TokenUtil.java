package com.zhenergy.zmp.api.web.security.utils;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.zhenergy.zmp.api.web.security.model.AuthUser;
import com.zhenergy.zmp.common.web.security.AbstractTokenUtil;

/**
 * The type Token util.
 */
@Component
@ConfigurationProperties("security.jwt")
public class TokenUtil extends AbstractTokenUtil {

    @Override
    public UserDetails getUserDetails(String token) {
        String userDetailsString = getUserDetailsString(token);
        if (userDetailsString != null) {
            return new Gson().fromJson(userDetailsString, AuthUser.class);
        }
        return null;
    }

}