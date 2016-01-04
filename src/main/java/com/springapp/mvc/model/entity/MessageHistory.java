package com.springapp.mvc.model.entity;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author a2driano
 * @version 2.0
 * @since 02.01.2016
 */
@Entity
@Table(name = "messagehistory")
@NamedQueries({
        @NamedQuery(name = "getUserMessagesByName", query = "SELECT a FROM MessageHistory a WHERE a.nickName= :nickName")
})
public class MessageHistory implements Serializable {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "nickname")
    private User user;

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private Integer id;

    @Column(name = "message", length = 500)
    private String messageUser;

    @Column(name = "date")
    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessageUser() {
        return messageUser;
    }

    public void setMessageUser(String messageUser) {
        this.messageUser = messageUser;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
