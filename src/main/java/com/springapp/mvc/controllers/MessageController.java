package com.springapp.mvc.controllers;

import com.springapp.mvc.model.web.MessageHistoryDTO;
import com.springapp.mvc.services.MessageHistoryService;
import com.springapp.mvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.xml.crypto.Data;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @MessageMapping("/messageadd")
    @SendTo("/topic/messagenew")
    public MessageHistoryDTO addMessage(@RequestBody MessageHistoryDTO messageHistoryDTO){
        System.err.println("MESSAGE IS delivered-------MESSAGE IS delivered-------MESSAGE IS delivered-------MESSAGE IS delivered-------");
        MessageHistoryDTO messageHistoryDTOReturn=messageHistoryService.addMessage(messageHistoryDTO);
        return messageHistoryDTOReturn;
    }

//    @RequestMapping(value = "/messageadd", method = RequestMethod.POST)
//    @ResponseBody
//    public MessageHistoryDTO addMessage(@RequestBody MessageHistoryDTO messageHistoryDTO){
//
//        MessageHistoryDTO messageHistoryDTOReturn=messageHistoryService.addMessage(messageHistoryDTO);
//        return messageHistoryDTOReturn;
//    }

    @RequestMapping(value = "/getallmessages", method = RequestMethod.GET)
    @ResponseBody
    public List<MessageHistoryDTO> list(){
        List<MessageHistoryDTO> list=new ArrayList<MessageHistoryDTO>();
        list=messageHistoryService.getAllUsersMessages();
        return list;
    }
}
