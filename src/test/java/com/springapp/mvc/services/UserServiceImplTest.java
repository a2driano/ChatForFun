package com.springapp.mvc.services;

import com.springapp.mvc.model.entity.User;
import com.springapp.mvc.model.entity.UserRole;
import com.springapp.mvc.repositories.UserRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.LoggingAssert;

import java.util.List;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.testng.Assert.*;

/**
 * @version 1.0
 * @autor a2driano
 * @project: ChatForFun
 * @since 13.02.2016
 */
public class UserServiceImplTest {

    private Assertion assertion = new LoggingAssert();

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl appService;

    @BeforeMethod
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetUserByName() throws Exception {
        when(userRepository.getByName(anyString())).thenReturn(new User());
        appService.getUserByName(anyString());
    }

    @Test
    public void testCreate() throws Exception {
    }

    @Test
    public void testGetAll() throws Exception {

    }

    @Test
    public void testGetByOnline() throws Exception {

    }

    @Test
    public void testConfirmUser() throws Exception {

    }

    @Test
    public void testEnterUser() throws Exception {

    }

    @Test
    public void testAddUser() throws Exception {

    }

    @Test
    public void testDeleteUser() throws Exception {

    }

    @Test
    public void testUpdateUser() throws Exception {

    }
}