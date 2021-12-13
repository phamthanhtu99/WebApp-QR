package com.example.Config;

import com.example.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    @Autowired
    private UserRepository userRepository;
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy() ;
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException {
        String targetUrl = determineTargetUrl(authentication);
        if (response.isCommitted()) {
            return;
        }
        redirectStrategy.sendRedirect(request, response, targetUrl);

    }
    public RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }
    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }
    private String determineTargetUrl(Authentication authentication) {
        String url = "";
        List<String> roles = SecurityUtils.getAuthorities();
        if (isOwner(roles)) {
            url = "/store";
        } else if (isUser(roles)) {
            url = "/";
        }else if (isStaff(roles)){
            url = "/staff";
        }
        return url;
    }

    private boolean isOwner(List<String> roles) {
        if (roles.contains("ROLE_OWNER")) {
            return true;
        }
        return false;
    }

    private boolean isUser(List<String> roles) {
        if (roles.contains("ROLE_USER")) {
            return true;
        }
        return false;
    }
    private boolean isStaff(List<String> roles) {
        if (roles.contains("ROLE_STAFF")) {
            return true;
        }
        return false;
    }

}
