package com.example.application.security;

import com.vaadin.flow.server.VaadinServletRequest;
import com.vaadin.flow.spring.annotation.VaadinSessionScope;
import com.vaadin.flow.spring.security.AuthenticationContext;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;

@Service
@VaadinSessionScope
public class SecurityService {

    private final AuthenticationContext authContext;

    public SecurityService(AuthenticationContext authContext) {
        this.authContext = authContext;
    }

    public boolean isUserLoggedIn() {
        return this.authContext.getAuthenticatedUser(UserDetails.class).isPresent();
    }
    public void logout() {
        SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
        logoutHandler.logout(VaadinServletRequest.getCurrent().getHttpServletRequest(), null, null);
    }
}
