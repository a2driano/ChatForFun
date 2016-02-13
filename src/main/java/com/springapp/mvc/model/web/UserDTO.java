package com.springapp.mvc.model.web;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.springapp.mvc.model.entity.MessageHistory;
import com.springapp.mvc.model.entity.UserRole;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

/**
 * @version 1.0
 * @autor a2driano
 * @project: ChatForFun
 * @since 04.01.2016
 */
@JsonAutoDetect
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class UserDTO implements Serializable {

    public UserDTO() {
    }

    private Integer id;

    @JsonProperty("name")
    private String nickName;

    @JsonProperty("password")
    private String passwordUser;

    private UserRole userRole = UserRole.USER;

    public UserRole getUserRole() {
        return userRole;
    }

    public UserDTO setUserRole(UserRole userRole) {
        this.userRole = userRole;
        return null;
    }

    private Boolean online;

    public Integer getId() {
        return id;
    }

    public UserDTO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getNickName() {
        return nickName;
    }

    public UserDTO setNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public UserDTO setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
        return this;
    }

    public Boolean getOnline() {
        return online;
    }

    public UserDTO setOnline(Boolean online) {
        this.online = online;
        return this;
    }

}
