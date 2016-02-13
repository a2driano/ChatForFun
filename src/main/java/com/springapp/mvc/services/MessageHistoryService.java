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

    /**
     * This methods return all messages of user by his id
     *
     * @param id
     * @return
     */
    List<MessageHistoryDTO> getUserMessagesById(Integer id);

    /**
     * This methods return all messages all users
     *
     * @return
     */
    List<MessageHistoryDTO> getAllUsersMessages();

    /**
     * This methods add amessage of user
     *
     * @param messageHistoryDTO
     * @return
     */
    MessageHistoryDTO addMessage(MessageHistoryDTO messageHistoryDTO);

    /**
     * This method delete message where id=messageid
     *
     * @param messageHistoryDTO
     * @return
     */
    MessageHistoryDTO delete(MessageHistoryDTO messageHistoryDTO);

}
