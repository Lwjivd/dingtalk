package com.zhenergy.zmp.api.web.security.model;

import com.zhenergy.zmp.system.api.entity.User;

/**
 * The type Auth user factory.
 */
public final class AuthUserFactory {

	
    private AuthUserFactory() {
    }

    /**
     * Create auth user.
     */
    public static AuthUser create(User user) {
        return new AuthUser(
        		user.getUserId(),
        		user.getMobile(),
        		user.getPassword(),
            true
        );
    }

}
