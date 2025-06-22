////////////////////////////////////////////////////////////////
package com.chachachat.utils;
////////////////////////////////////////////////////////////////
import org.springframework.security.authentication
                          .AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context
                                   .SecurityContextHolder;
////////////////////////////////////////////////////////////////
public class AuthUtils {
    public static Authentication auth() {
        return SecurityContextHolder.getContext()
                                    .getAuthentication();
    }
    public static boolean isAnonymous() {
        return auth() instanceof AnonymousAuthenticationToken;
    }
    public static String getUsername() {
        return auth().getName();
    }
}
////////////////////////////////////////////////////////////////
