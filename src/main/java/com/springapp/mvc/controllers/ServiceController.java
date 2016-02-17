package com.springapp.mvc.controllers;

import com.springapp.mvc.model.web.MessageHistoryDTO;
import com.springapp.mvc.services.MessageHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @version 1.0
 * @autor a2driano
 * @project: ChatForFun
 * @since 06.02.2016
 */
@Controller
public class ServiceController {

    @Autowired
    MessageHistoryService messageHistoryService;

    //return service_page (for admin role)
    @RequestMapping(value = "/service_page")
    public String index() {
        return "service_page";
    }

    //delete message (for admin role)
    @RequestMapping(value = "/delete_message", method = RequestMethod.POST)
    @ResponseBody
    public MessageHistoryDTO delMes(@RequestBody MessageHistoryDTO messageHistoryDTO) {
        MessageHistoryDTO messageHistoryDTOReturn = messageHistoryService.delete(messageHistoryDTO);
        return messageHistoryDTOReturn;
    }

    //delete message (for admin role)
    @RequestMapping(value = "/messageAddAdmin", method = RequestMethod.POST)
    @ResponseBody
    public MessageHistoryDTO addMessage(@RequestBody MessageHistoryDTO messageHistoryDTO) {
        MessageHistoryDTO messageHistoryDTOReturn = messageHistoryService.addMessage(messageHistoryDTO);
        return messageHistoryDTOReturn;
    }
}

