package com.springapp.mvc.services;

import com.springapp.mvc.model.entity.MessageHistory;
import com.springapp.mvc.model.web.MessageHistoryDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version 1.0
 * @autor a2driano
 * @project: ChatForFun
 * @since 05.01.2016
 */
@Service
public class MessageHistoryServiceImpl implements MessageHistoryService {

    @Override
    public List<MessageHistoryDTO> getUserMessagesById(Integer id) {
        return null;
    }

    @Override
    public List<MessageHistoryDTO> getAllUsersMessages() {
        return null;
    }

    @Override
    public MessageHistoryDTO addMessage() {
        return null;
    }
}
