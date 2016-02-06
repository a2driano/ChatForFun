package com.springapp.mvc.repositories;

import com.springapp.mvc.model.entity.MessageHistory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @version 1.0
 * @autor a2driano
 * @project: ChatForFun
 * @since 05.01.2016
 */
//This class worked with MessageHistory in DB
@Repository
@Transactional
public class MessageHistoryRepositoryImpl implements MessageHistoryRepository {
    @Override
    public MessageHistory getMessageById(Integer Id) {
        return (MessageHistory)entityManager.createNamedQuery("getMessageById").setParameter("messageId", Id).getSingleResult();
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<MessageHistory> getUserMessagesById(Integer Id) {
        return entityManager.createNamedQuery("getUserMessagesById").setParameter("id", Id).getResultList();
    }

    @Override
    public List<MessageHistory> getAllUsersMessages() {
        return entityManager.createNamedQuery("getAllUsersMessages").getResultList();
    }

    @Override
    public void add(MessageHistory messageHistory) {
        entityManager.persist(messageHistory);
    }

    @Override
    public void delete(MessageHistory messageHistory) {
        System.err.println("-------------------------------------  "+messageHistory.getMessageId());
        entityManager.remove(getMessageById(messageHistory.getMessageId()));
    }

    @Override
    public void update(MessageHistory messageHistory) {
        entityManager.merge(messageHistory);
    }
}
