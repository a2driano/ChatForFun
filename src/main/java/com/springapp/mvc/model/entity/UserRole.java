package com.springapp.mvc.model.entity;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.CollectionTable;
import java.util.Collection;

/**
 * @version 1.0
 * @autor a2driano
 * @project: ChatForFun
 * @since 20.01.2016
 */
//public enum UserRole implements GrantedAuthority {
public enum UserRole {

//    @CollectionTable(name = "user_roles")
//    ANONYMOUS("ROLE_ANONYMOUS"),
    USER(),
    ADMIN();

//    private String authority;
//
//    UserRole(String authority){
//        this.authority=authority;
//    }
//
//    @Override
//    public String getAuthority() {
//        return this.authority;
//    }

}
