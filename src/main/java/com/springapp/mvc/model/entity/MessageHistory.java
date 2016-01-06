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
        @NamedQuery(name = "getUserMessagesById", query = "SELECT a FROM MessageHistory a WHERE a.user.id= :id"),
        @NamedQuery(name = "getAllUsersMessages", query = "SELECT a FROM MessageHistory a")
})
public class MessageHistory implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "message_id")
    private Integer messageId;

    @Column(name = "message", length = 500)
    private String messageUser;

    @Column(name = "date")
    private Date date;

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
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
