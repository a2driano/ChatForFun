package com.springapp.mvc.controllers;

import com.springapp.mvc.model.web.UserDTO;
import com.springapp.mvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/**
 * @version 1.0
 * @autor a2driano
 * @project: ChatForFun
 * @since 04.01.2016
 */

@Controller
public class HelloController {


    @Autowired
    private UserService userService;

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/registration")
    public String registration() {
        return "registration";
    }

    @RequestMapping(value = "/login")
    public String login(Model model) {
        return "login";
    }


    @RequestMapping(value = "/chat")
    public String chat() {
        return "chat";
    }

    @ResponseBody
    @RequestMapping(value = "/del", method = RequestMethod.GET)
    public UserDTO deleteUser(@RequestParam int id) {
        return userService.deleteUser(id);
    }
}