package com.springapp.mvc.services;

import com.springapp.mvc.model.entity.MessageHistory;
import com.springapp.mvc.model.entity.User;
import com.springapp.mvc.model.web.MessageHistoryDTO;
import com.springapp.mvc.model.web.UserDTO;
import com.springapp.mvc.repositories.MessageHistoryRepository;
import com.springapp.mvc.repositories.UserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.management.ObjectName;
import java.util.*;

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
    public List<MessageHistoryDTO> getUserMessagesById(Integer id) {
        List<MessageHistoryDTO> messageHistoryDTOList = new ArrayList<MessageHistoryDTO>();
        try {
            List<MessageHistory> messageHistoryList = messageHistoryRepository.getUserMessagesById(id);
            for (MessageHistory messageHistory : messageHistoryList) {
                messageHistoryDTOList.add(new MessageHistoryDTO()
                        .setMessageUser(messageHistory.getMessageUser())
                        .setId(messageHistory.getMessageId())
                        .setDate(messageHistory.getDate())
                        .setUser(messageHistory.getUser()));
            }
        } catch (Exception e) {
            LOGGER.error("{}", e.toString(), e);
        }
        return messageHistoryDTOList;
    }

    @Override
    public List<MessageHistoryDTO> getAllUsersMessages() {
        List<MessageHistoryDTO> messageHistoryDTOList = new ArrayList<MessageHistoryDTO>();
        try {
            List<MessageHistory> messageHistoryList = messageHistoryRepository.getAllUsersMessages();
            for (MessageHistory messageHistory : messageHistoryList) {
                messageHistoryDTOList.add(new MessageHistoryDTO()
                        .setMessageUser(messageHistory.getMessageUser())
                        .setName(messageHistory.getUser().getNickName())
                        .setId(messageHistory.getMessageId())
                        .setDate(messageHistory.getDate()));
            }
            //sort collection by date
            Collections.sort(messageHistoryDTOList, new Comparator<MessageHistoryDTO>() {
                public int compare(MessageHistoryDTO o1, MessageHistoryDTO o2) {
                    return o1.getDate().toString().compareTo(o2.getDate().toString());
                }
            });
        } catch (Exception e) {
            LOGGER.error("{}", e.toString(), e);
        }
        return messageHistoryDTOList;
    }

    @Override
    public MessageHistoryDTO addMessage(MessageHistoryDTO messageHistoryDTO) {
        MessageHistory messageHistory = new MessageHistory();
        messageHistory.setUser(userRepository.getByName(messageHistoryDTO.getName()));
        messageHistory.setMessageUser(messageHistoryDTO.getMessageUser());
        messageHistory.setDate(messageHistoryDTO.getDate());
        try {
            messageHistoryRepository.add(messageHistory);
        } catch (Exception e) {
            LOGGER.error("{}", e.toString(), e);
            return null;
        }
        MessageHistoryDTO messageHistoryDTOReturn = new MessageHistoryDTO();
        messageHistoryDTOReturn.setDate(messageHistory.getDate()).setMessageUser(messageHistory.getMessageUser()).setName(messageHistoryDTO.getName()).setId(messageHistory.getMessageId());
        return messageHistoryDTOReturn;
    }

    @Override
    public MessageHistoryDTO delete(MessageHistoryDTO messageHistoryDTO) {
        Integer id=messageHistoryDTO.getId();
        String name=messageHistoryDTO.getName();
        try {
            MessageHistory messageHistory=new MessageHistory();
            messageHistory.setMessageId(id);
            messageHistoryRepository.delete(messageHistory);
        }catch (Exception e){
            return null;
        }
        return messageHistoryDTO.setId(id).setName(name);
    }
}
