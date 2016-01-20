package com.springapp.mvc.model.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author a2driano
 * @version 2.0
 * @since 02.01.2016
 */
@Entity
@Table(name = "users")
@NamedQueries({
        @NamedQuery(name = "getAllUsers", query = "SELECT a FROM User a"),
        @NamedQuery(name = "getUserByName", query = "SELECT a FROM User a WHERE a.nickName= :nickName"),
        @NamedQuery(name = "getByOnline", query = "SELECT a FROM User a WHERE a.online=true"),
        @NamedQuery(name = "userNameIsPresent", query = "SELECT COUNT(a) from User a WHERE a.nickName= :nickName"),
        @NamedQuery(name = "userNameAndPasswordIsPresent", query = "SELECT COUNT(a) from User a WHERE a.nickName= :nickName AND a.passwordUser= :passwordUser"),
        @NamedQuery(name = "getById", query = "SELECT a FROM User a WHERE a.id= :id"),
        @NamedQuery(name = "getUserByNameAndPassword", query = "SELECT a FROM User a WHERE a.nickName= :nickName AND a.passwordUser= :passwordUser")
})
public class User implements Serializable {

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<MessageHistory> messageHistoryList;

    public List<MessageHistory> getMessageHistoryList() {
        return messageHistoryList;
    }

    public void setMessageHistoryList(List<MessageHistory> messageHistoryList) {
        this.messageHistoryList = messageHistoryList;
    }

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<UserRole> userRoles;

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public User setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
        return this;
    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private Integer id;


    @Column(name = "nickname", length = 100, unique = true)
    private String nickName;

    @Column(name = "passworduser")
    private String passwordUser;

    @Column(name = "online")
    private Boolean online;

    public Integer getId() {
        return id;
    }

    public User setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getNickName() {
        return nickName;
    }

    public User setNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public User setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
        return this;
    }

    public Boolean getOnline() {
        return online;
    }

    public User setOnline(Boolean online) {
        this.online = online;
        return this;
    }
}
