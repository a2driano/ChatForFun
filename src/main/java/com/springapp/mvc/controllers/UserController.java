package com.springapp.mvc.controllers;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.springapp.mvc.model.web.UserDTO;
import com.springapp.mvc.model.web.UserResponce;
import com.springapp.mvc.model.web.UserResponceStatus;
import com.springapp.mvc.services.MessageHistoryService;
import com.springapp.mvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView addUser(@RequestBody UserDTO userDTO) {
        UserResponce userResponce=userService.addUser(userDTO);
        ModelAndView modelAndView=new ModelAndView();
        if(userResponce.getUserResponceStatus()== UserResponceStatus.SUCCESS){
            modelAndView.setViewName("chat");
            modelAndView.addObject("status", userResponce.getUserResponceStatus());
            modelAndView.addObject("name", userResponce.getUserDTO().getNickName());
            modelAndView.addObject("password", userResponce.getUserDTO().getPasswordUser());
            modelAndView.addObject("id", userResponce.getUserDTO().getId());
            modelAndView.addObject("status", userResponce.getMessage());
            return modelAndView;
        }else {
            modelAndView.setViewName("chat");
            modelAndView.addObject("status", userResponce.getUserResponceStatus());
            modelAndView.addObject("status", userResponce.getMessage());
//            modelAndView.addObject("name", userResponce.getUserDTO().getNickName());
//            modelAndView.addObject("password", userResponce.getUserDTO().getPasswordUser());
//            modelAndView.addObject("id", userResponce.getUserDTO().getId());
            return modelAndView;
        }
    }
//    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
//    @ResponseBody
//    public UserResponce addUser(@RequestBody UserDTO userDTO) {
//        return userService.addUser(userDTO);
//    }

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
