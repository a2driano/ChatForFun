package com.springapp.mvc.services;

import com.springapp.mvc.model.entity.User;
import com.springapp.mvc.model.web.UserDTO;
import com.springapp.mvc.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * @version 1.0
 * @autor a2driano
 * @project: ChatForFun
 * @since 21.01.2016
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

        User user=userRepository.getByName(name);
        Set<GrantedAuthority> roles=new HashSet<>();

        UserDetails userDetails=new org.springframework.security.core.userdetails.User(user.getNickName(),
                user.getPasswordUser(), roles);

        return userDetails;
    }
}