package com.springapp.mvc.repositories;

import com.springapp.mvc.model.entity.MessageHistory;
import com.springapp.mvc.model.entity.User;

import java.util.List;

/**
 * @version 1.0
 * @autor a2driano
 * @project: ChatForFun
 * @since 05.01.2016
 */
public interface MessageHistoryRepository {

    /**
     * return all messages by concrete user
     *
     * @param Id
     * @return
     */
    List<MessageHistory> getUserMessagesById(Integer Id);

    /**
     * return all messages
     *
     * @return
     */
    List<MessageHistory> getAllUsersMessages();

    /**
     * return message by concrete user
     *
     * @param Id
     * @return
     */
    MessageHistory getMessageById(Integer Id);

    /**
     * add message
     *
     * @param messageHistory
     */
    void add(MessageHistory messageHistory);

    /**
     * delete message
     *
     * @param messageHistory
     */
    void delete(MessageHistory messageHistory);

    /**
     * update message
     *
     * @param messageHistory
     */
    void update(MessageHistory messageHistory);

}
