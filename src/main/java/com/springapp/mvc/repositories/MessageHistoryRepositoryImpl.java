package com.springapp.mvc.repositories;

import com.springapp.mvc.model.entity.MessageHistory;

import java.util.List;

/**
 * @version 1.0
 * @autor a2driano
 * @project: ChatForFun
 * @since 05.01.2016
 */
public class MessageHistoryRepositoryImpl implements MessageHistoryRepository {
    @Override
    public List<MessageHistory> getMessagesByName(String nickName) {
        return null;
    }

    @Override
    public void add(MessageHistory messageHistory) {

    }

    @Override
    public void delete(MessageHistory messageHistory) {

    }

    @Override
    public void update(MessageHistory messageHistory) {

    }
}
