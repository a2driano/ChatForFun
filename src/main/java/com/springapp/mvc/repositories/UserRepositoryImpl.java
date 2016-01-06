package com.springapp.mvc.repositories;

import com.springapp.mvc.model.entity.User;
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

//This class worked with User in DB
@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User getByUser(String nickName, String passwordUser) {
        return (User) entityManager.createNamedQuery("getUserByNameAndPassword").setParameter("nickName", nickName).setParameter("passwordUser", passwordUser).getSingleResult();
    }

    @Override
    public User getByName(String nickName) {
        return (User)entityManager.createNamedQuery("getUserByName").setParameter("nickName", nickName).getSingleResult();
    }

    @Override
    public List<User> getAll() {
        return entityManager.createNamedQuery("getAllUsers").getResultList();
    }

    @Override
    public void delete(User user) {
        entityManager.remove(user);
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    public List<User> getByOnline() {
        return entityManager.createNamedQuery("getByOnline").getResultList();
    }
}
