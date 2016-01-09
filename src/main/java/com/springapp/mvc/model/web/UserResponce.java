package com.springapp.mvc.model.web;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;

/**
 * @version 1.0
 * @autor a2driano
 * @project: ChatForFun
 * @since 09.01.2016
 */
@JsonAutoDetect
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class UserResponce implements Serializable{

    @JsonProperty("status")
    private UserResponceStatus userResponceStatus;

    private UserDTO userDTO;

    @JsonProperty("message")
    private String message;

    public UserResponceStatus getUserResponceStatus() {
        return userResponceStatus;
    }

    public UserResponce setUserResponceStatus(UserResponceStatus userResponceStatus) {
        this.userResponceStatus = userResponceStatus;
        return this;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public UserResponce setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public UserResponce setMessage(String message) {
        this.message = message;
        return this;
    }
}
