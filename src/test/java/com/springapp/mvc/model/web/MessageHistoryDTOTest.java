package com.springapp.mvc.model.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springapp.mvc.model.entity.User;
import junit.framework.TestCase;
import org.testng.Assert;

import java.io.StringWriter;
import java.io.Writer;
import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Created by Admin on 13.02.2016.
 */
public class MessageHistoryDTOTest extends TestCase {

    public void testGetName() throws Exception {
        MessageHistoryDTO messageHistoryDTO = new MessageHistoryDTO();
        messageHistoryDTO.setName("user");
        Assert.assertEquals((String) "user", messageHistoryDTO.getName());
    }

    public void testSetName() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        MessageHistoryDTO messageHistoryDTO = new MessageHistoryDTO().setName("user");
        try {
            System.out.println(mapper.writeValueAsString(messageHistoryDTO));
        } catch (JsonProcessingException ex) {
            System.out.println(ex);
        }
    }

    public void testGetId() throws Exception {
        MessageHistoryDTO messageHistoryDTO = new MessageHistoryDTO();
        messageHistoryDTO.setId(1);
        Assert.assertEquals((Integer) 1, messageHistoryDTO.getId());
    }

    public void testSetId() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        MessageHistoryDTO messageHistoryDTO = new MessageHistoryDTO().setId(1);
        try {
            System.out.println(mapper.writeValueAsString(messageHistoryDTO));
        } catch (JsonProcessingException ex) {
            System.out.println(ex);
        }
    }

    public void testGetUser() throws Exception {
    }

    public void testSetUser() throws Exception {

    }

    public void testGetMessageUser() throws Exception {
        MessageHistoryDTO messageHistoryDTO = new MessageHistoryDTO();
        messageHistoryDTO.setMessageUser("1");
        Assert.assertEquals((String) "1", messageHistoryDTO.getMessageUser());
    }

    public void testSetMessageUser() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        MessageHistoryDTO messageHistoryDTO = new MessageHistoryDTO().setMessageUser("1");
        try {
            System.out.println(mapper.writeValueAsString(messageHistoryDTO));
        } catch (JsonProcessingException ex) {
            System.out.println(ex);
        }
    }

    public void testGetDate() throws Exception {
        MessageHistoryDTO messageHistoryDTO = new MessageHistoryDTO();
        messageHistoryDTO.setDate(new Date());
        Assert.assertEquals((Date) new Date(), messageHistoryDTO.getDate());
    }

    public void testSetDate() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        MessageHistoryDTO messageHistoryDTO = new MessageHistoryDTO().setDate(new Date());
        try {
            System.out.println(mapper.writeValueAsString(messageHistoryDTO));
        } catch (JsonProcessingException ex) {
            System.out.println(ex);
        }
    }
}