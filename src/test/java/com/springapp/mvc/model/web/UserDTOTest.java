package com.springapp.mvc.model.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

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

    }

    @Test
    public void testSetUserRole() throws Exception {

    }

    @Test
    public void testGetId() throws Exception {

    }

    @Test
    public void testSetId() throws Exception {
        ObjectMapper mapper=new ObjectMapper();
        UserDTO userDTO=new UserDTO().setId(1);
        try{
            System.out.println(mapper.writeValueAsString(userDTO));

        }catch (JsonProcessingException ex){
            System.out.println(ex);
        }
    }
//    @Test
//    public void testSetId() {
//        ObjectMapper mapper = new ObjectMapper();
//        DishDto dishDto = new DishDto().setDishId(1);
//        try {
//            System.out.println(mapper.writeValueAsString(dishDto));
//        } catch (JsonProcessingException ex) {
//            System.out.println(ex);
//        }
//    }

    @Test
    public void testGetNickName() throws Exception {

    }

    @Test
    public void testSetNickName() throws Exception {

    }

    @Test
    public void testGetPasswordUser() throws Exception {

    }

    @Test
    public void testSetPasswordUser() throws Exception {

    }

    @Test
    public void testGetOnline() throws Exception {

    }

    @Test
    public void testSetOnline() throws Exception {

    }
}