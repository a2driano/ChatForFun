package com.springapp.mvc.model;

import com.springapp.mvc.model.entity.UserRole;
import com.sun.istack.internal.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @version 1.0
 * @autor a2driano
 * @project: ChatForFun
 * @since 23.01.2016
 */
public class UserCreateForm {
    @NotEmpty
    private String name = "";

    @NotEmpty
    private String password = "";

    @NotNull
    private UserRole userRole = UserRole.USER;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

}
