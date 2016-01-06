package com.springapp.mvc.model.web;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.springapp.mvc.model.entity.User;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @version 1.0
 * @autor a2driano
 * @project: ChatForFun
 * @since 04.01.2016
 */
@JsonAutoDetect
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class MessageHistoryDTO {

    @JsonProperty
    private Integer messageId;

    @JsonProperty
    private User user;

    @JsonProperty
    private String messageUser;

    @JsonProperty
    private Date date;

    public Integer getId() {
        return messageId;
    }

    public MessageHistoryDTO setId(Integer id) {
        this.messageId = id;
        return this;
    }

    public User getUser() {
        return user;
    }

    public MessageHistoryDTO setUser(User user) {
        this.user = user;
        return this;
    }

    public String getMessageUser() {
        return messageUser;
    }

    public MessageHistoryDTO setMessageUser(String messageUser) {
        this.messageUser = messageUser;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public MessageHistoryDTO setDate(Date date) {
        this.date = date;
        return this;
    }
}
