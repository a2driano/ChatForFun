package com.springapp.mvc.controllers;

import com.springapp.mvc.model.web.MessageHistoryDTO;
import com.springapp.mvc.services.MessageHistoryService;
import com.springapp.mvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.crypto.Data;
import java.security.Principal;
import java.util.Date;

/**
 * @version 1.0
 * @autor a2driano
 * @project: ChatForFun
 * @since 28.01.2016
 */
@Controller
public class MessageController {
    @Autowired
    UserService userService;
    @Autowired
    private MessageHistoryService messageHistoryService;

    @RequestMapping(value = "/messageadd", method = RequestMethod.POST)
    @ResponseBody
    public MessageHistoryDTO addMessage(@RequestBody MessageHistoryDTO messageHistoryDTO){

        messageHistoryService.addMessage(messageHistoryDTO);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();


        Date date= messageHistoryDTO.getDate();
        String mes=messageHistoryDTO.getMessageUser();
        System.err.println(mes+" ------ "+name+" ------ "+date.toString());
        return null;
    }
}
