package com.springapp.mvc.controllers;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.springapp.mvc.model.web.UserDTO;
import com.springapp.mvc.model.web.UserResponce;
import com.springapp.mvc.services.MessageHistoryService;
import com.springapp.mvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @version 1.0
 * @autor a2driano
 * @project: levelup
 * @since 09.01.2016
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private MessageHistoryService messageHistoryService;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    @ResponseBody
    public UserResponce addUser(@RequestBody UserDTO userDTO) {
        return userService.addUser(userDTO);
    }
}
