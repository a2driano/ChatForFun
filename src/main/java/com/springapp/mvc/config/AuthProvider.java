package com.springapp.mvc.config;

import com.springapp.mvc.model.entity.User;
import com.springapp.mvc.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * @autor a2driano
 * @project: ChatForFun
 * @since 20.01.2016
 */
@Component
public class AuthProvider implements AuthenticationProvider {

    @Autowired
    UserRepository userRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String password = (String)authentication.getCredentials();

//        User user = userRepository.getByName(name);
        User user = userRepository.getByUser(name, password);
        if (user == null){
            throw new BadCredentialsException("User not found");
        }
        if (!password.equals(password)){
            throw new BadCredentialsException("Pass not match");
        }
        return new UsernamePasswordAuthenticationToken(name,password, AuthorityUtils.createAuthorityList(user.getUserRole().toString()));
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }


}
