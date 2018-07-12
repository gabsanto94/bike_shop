package com.revature.bikeshop.utils;

import com.revature.bikeshop.model.User;
import com.revature.bikeshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

@Component("customAuthenticationProvider")
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserService us;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        System.out.println("im getting authenticated.");

        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;

        User user = us.getUserByUsername(token.getName());

        //inspect the credentials
        if(!user.getPassword().equalsIgnoreCase(token.getCredentials().toString())){
            throw new BadCredentialsException("The Credentials Are Invalid.");
        }

        //we need a new authentication object
        return new UsernamePasswordAuthenticationToken(user, user.getPassword(), AuthorityUtils.createAuthorityList(user.getUserRole()));

    }

    @Override
    public boolean supports(Class<?> aClass) {
        return UsernamePasswordAuthenticationToken.class.equals(aClass);
    }

}
