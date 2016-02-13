package com.springapp.mvc.controllers;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.springapp.mvc.model.web.UserDTO;
import com.springapp.mvc.model.web.UserResponce;
import com.springapp.mvc.model.web.UserResponceStatus;
import com.springapp.mvc.services.MessageHistoryService;
import com.springapp.mvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @version 1.0
 * @autor a2driano
 * @project: ChatForFun
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
    public String addUser(@RequestBody UserDTO userDTO) {
        userService.addUser(userDTO);
        return "/";
    }

    @ResponseBody
    @RequestMapping(value = "/getName", method = RequestMethod.GET)
    public String getName(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        System.err.println(name);
        return name;
    }

    @RequestMapping(value = "/confirmUser", method = RequestMethod.POST)
    @ResponseBody
    public UserResponce confirmUser(@RequestBody UserDTO userDTO) {
        return userService.confirmUser(userDTO);
    }

    @RequestMapping(value = "/enterUser", method = RequestMethod.POST)
    @ResponseBody
    public UserResponce enterUser(@RequestBody UserDTO userDTO) {
        return userService.enterUser(userDTO);
    }
}
