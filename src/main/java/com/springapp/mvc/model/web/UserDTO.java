package com.springapp.mvc.model.web;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.springapp.mvc.model.entity.MessageHistory;

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

    @JsonProperty
    private Integer id;

    @JsonProperty
    private String nickName;

    @JsonIgnore
    private String passwordUser;

    @JsonProperty
    private Boolean usingnickname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    public Boolean getUsingnickname() {
        return usingnickname;
    }

    public void setUsingnickname(Boolean usingnickname) {
        this.usingnickname = usingnickname;
    }
}
