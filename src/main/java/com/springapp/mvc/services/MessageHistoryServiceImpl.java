package com.springapp.mvc.services;

import com.springapp.mvc.model.entity.MessageHistory;
import com.springapp.mvc.model.entity.User;
import com.springapp.mvc.model.web.MessageHistoryDTO;
import com.springapp.mvc.model.web.UserDTO;
import com.springapp.mvc.repositories.MessageHistoryRepository;
import com.springapp.mvc.repositories.UserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @autor a2driano
 * @project: ChatForFun
 * @since 05.01.2016
 */
@Service
public class MessageHistoryServiceImpl implements MessageHistoryService {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(MessageHistoryServiceImpl.class);
    @Autowired
    private MessageHistoryRepository messageHistoryRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<MessageHistoryDTO> getUserMessagesById(Integer id)
    {
        return null;
    }

    @Override
    public List<MessageHistoryDTO> getAllUsersMessages() {
        List<MessageHistoryDTO> messageHistoryDTOList=new ArrayList<MessageHistoryDTO>();
        try {
            List<MessageHistory> messageHistoryList=messageHistoryRepository.getAllUsersMessages();
            for(MessageHistory messageHistory: messageHistoryList){
                messageHistoryDTOList.add(new MessageHistoryDTO()
                .setMessageUser(messageHistory.getMessageUser())
                .setId(messageHistory.getMessageId())
                .setDate(messageHistory.getDate())
                .setUser(messageHistory.getUser()));
            }
        }catch (Exception e){
            LOGGER.error("{}",e.toString(),e);
        }
        return messageHistoryDTOList;
    }

    @Override
    public MessageHistoryDTO addMessage(MessageHistoryDTO messageHistoryDTO) {
        try{
            MessageHistory messageHistory=new MessageHistory();
            messageHistory.setMessageId(messageHistoryDTO.getId());
            messageHistory.setMessageUser(messageHistoryDTO.getMessageUser());
            messageHistory.setDate(messageHistoryDTO.getDate());
            messageHistory.setUser(messageHistoryDTO.getUser());
        }catch (Exception e){
            LOGGER.error("{}",e.toString(),e);
        }

        return null;
    }
}
