package com.springapp.mvc.model.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

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
        @NamedQuery(name = "getUserByNameAndPassword", query = "SELECT a FROM User a WHERE a.nickName= :nickName AND a.passwordUser= :passwordUser")
})
public class User implements Serializable {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private Integer id;

    @Column(name = "nickname", nullable = false, length = 100, unique = true)
    private String nickName;

    @Column(name = "passworduser")
    private String passwordUser;

    @Column(name = "online")
    private Boolean online;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<MessageHistory> message;

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
}
