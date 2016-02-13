package com.springapp.mvc.model.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springapp.mvc.model.entity.UserRole;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.*;

/**
 * @version 1.0
 * @autor a2driano
 * @project: ChatForFun
 * @since 13.02.2016
 */
public class UserDTOTest {

    @Test
    public void testGetUserRole() throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserRole(UserRole.USER);
        Assert.assertEquals(UserRole.USER, userDTO.getUserRole());
    }

    @Test
    public void testSetUserRole() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        UserDTO userDTO = new UserDTO().setUserRole(UserRole.USER);
        try {
            System.out.println(mapper.writeValueAsString(userDTO));
        } catch (JsonProcessingException ex) {
            System.out.println(ex);
        }
    }

    @Test
    public void testGetId() throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1);
        Assert.assertEquals((Integer) 1, userDTO.getId());
    }

    @Test
    public void testSetId() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        UserDTO userDTO = new UserDTO().setId(1);
        try {
            System.out.println(mapper.writeValueAsString(userDTO));
        } catch (JsonProcessingException ex) {
            System.out.println(ex);
        }
    }

    @Test
    public void testGetNickName() throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setNickName("user");
        Assert.assertEquals((String) "user", userDTO.getNickName());
    }

    @Test
    public void testSetNickName() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        UserDTO userDTO = new UserDTO().setNickName("user");
        try {
            System.out.println(mapper.writeValueAsString(userDTO));
        } catch (JsonProcessingException ex) {
            System.out.println(ex);
        }
    }

    @Test
    public void testGetPasswordUser() throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setPasswordUser("user");
        Assert.assertEquals((String) "user", userDTO.getPasswordUser());
    }

    @Test
    public void testSetPasswordUser() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        UserDTO userDTO = new UserDTO().setPasswordUser("user");
        try {
            System.out.println(mapper.writeValueAsString(userDTO));
        } catch (JsonProcessingException ex) {
            System.out.println(ex);
        }
    }

    @Test
    public void testGetOnline() throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setOnline(true);
        Assert.assertEquals((Boolean) true, userDTO.getOnline());
    }

    @Test
    public void testSetOnline() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        UserDTO userDTO = new UserDTO().setOnline(true);
        try {
            System.out.println(mapper.writeValueAsString(userDTO));
        } catch (JsonProcessingException ex) {
            System.out.println(ex);
        }
    }
}