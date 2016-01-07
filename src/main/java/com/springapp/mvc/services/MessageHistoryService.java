package com.springapp.mvc.services;

import com.springapp.mvc.model.entity.MessageHistory;
import com.springapp.mvc.model.web.MessageHistoryDTO;

import java.util.List;

/**
 * @version 1.0
 * @autor a2driano
 * @project: ChatForFun
 * @since 05.01.2016
 */
public interface MessageHistoryService {

    List<MessageHistoryDTO> getUserMessagesById(Integer id);

    List<MessageHistoryDTO> getAllUsersMessages();

    MessageHistoryDTO addMessage(MessageHistoryDTO messageHistoryDTO);

}
