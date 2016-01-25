package com.springapp.mvc.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @version 1.0
 * @autor a2driano
 * @project: ChatForFun
 * @since 24.01.2016
 */
public interface UserDetailsService {
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
