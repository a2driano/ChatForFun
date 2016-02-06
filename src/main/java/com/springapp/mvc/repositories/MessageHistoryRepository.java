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

    List<MessageHistory> getUserMessagesById(Integer Id);

    List<MessageHistory> getAllUsersMessages();

    MessageHistory getMessageById(Integer Id);

    void add(MessageHistory messageHistory);

    void delete(MessageHistory messageHistory);

    void update(MessageHistory messageHistory);

}
