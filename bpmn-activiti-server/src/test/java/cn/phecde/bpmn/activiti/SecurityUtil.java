package cn.phecde.bpmn.activiti;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * 工具
 * 
 * @author PinWei Wan
 */
@Component
@Slf4j
public class SecurityUtil {
    private final static List<User> users = new ArrayList<>();

    {
        String[][] usersGroupsAndRoles = {
                { "system", "password", "ROLE_ACTIVITI_USER" },
                { "admin", "password", "ROLE_ACTIVITI_ADMIN" },
                { "reviewer", "password", "ROLE_ACTIVITI_USER" },
                { "bob", "password", "ROLE_ACTIVITI_USER", "GROUP_activitiTeam" },
                { "john", "password", "ROLE_ACTIVITI_USER", "GROUP_activitiTeam" },
                { "hannah", "password", "ROLE_ACTIVITI_USER", "GROUP_activitiTeam" },
                { "salaboy", "password", "ROLE_ACTIVITI_USER", "GROUP_activitiTeam" },
                { "ryandawsonuk", "password", "ROLE_ACTIVITI_USER", "GROUP_activitiTeam" },
                { "erdemedeiros", "password", "ROLE_ACTIVITI_USER", "GROUP_activitiTeam" },
                { "other", "password", "ROLE_ACTIVITI_USER", "GROUP_otherTeam" },
        };

        for (String[] user : usersGroupsAndRoles) {
            List<String> authoritiesStrings = Arrays.asList(Arrays.copyOfRange(user, 2, user.length));
            log.info("> Registering new user: " + user[0] + " with the following Authorities[" + authoritiesStrings + "]");
            users.add(new User(user[0], user[1],
                    authoritiesStrings.stream().map(s -> new SimpleGrantedAuthority(s)).collect(Collectors.toList())));
        }
    }

    public void logInAs(String username) {
        final UserDetails user = users.stream().filter(e -> e.getUsername().equals(username)).findAny().orElse(null);
        
        if (user == null) {
            throw new IllegalStateException("User " + username + " doesn't exist, please provide a valid user");
        }
        log.info("> Logged in as: " + username);
        SecurityContextHolder.setContext(new SecurityContextImpl(new Authentication() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return user.getAuthorities();
            }

            @Override
            public Object getCredentials() {
                return user.getPassword();
            }

            @Override
            public Object getDetails() {
                return user;
            }

            @Override
            public Object getPrincipal() {
                return user;
            }

            @Override
            public boolean isAuthenticated() {
                return true;
            }

            @Override
            public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

            }

            @Override
            public String getName() {
                return user.getUsername();
            }
        }));
        org.activiti.engine.impl.identity.Authentication.setAuthenticatedUserId(username);
    }
}
