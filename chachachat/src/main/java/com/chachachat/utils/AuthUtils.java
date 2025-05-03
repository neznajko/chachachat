////////////////////////////////////////////////////////////////
package com.chachachat.utils;
////////////////////////////////////////////////////////////////
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
////////////////////////////////////////////////////////////////
public class AuthUtils {
    public static boolean isAnonymous() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth instanceof AnonymousAuthenticationToken;
    }
}
////////////////////////////////////////////////////////////////
