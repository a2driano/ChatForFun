package com.springapp.mvc.controllers;

import com.springapp.mvc.model.web.MessageHistoryDTO;
import com.springapp.mvc.services.MessageHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;
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
    private MessageHistoryService messageHistoryService;

    @MessageMapping("/messageadd")
    @SendTo("/topic/messagenew")
    public MessageHistoryDTO addMessage(@Payload MessageHistoryDTO messageHistory) throws Exception {
        MessageHistoryDTO messageHistoryDTO = messageHistoryService.addMessage(messageHistory);
        return messageHistoryDTO;
    }

    @RequestMapping(value = "/getallmessages", method = RequestMethod.GET)
    @ResponseBody
    public List<MessageHistoryDTO> list() {
        List<MessageHistoryDTO> list = new ArrayList<MessageHistoryDTO>();
        list = messageHistoryService.getAllUsersMessages();
        return list;
    }
}
