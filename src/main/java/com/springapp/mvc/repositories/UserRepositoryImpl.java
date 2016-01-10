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
    public User getById (Integer id) {
        return (User) entityManager.
                createNamedQuery("getById").
                setParameter("id", id).
                getSingleResult();
    }

    @Override
    public Boolean isPresent(String nickName) {
        return (Long)entityManager.createNamedQuery("userNameIsPresent").setParameter("nickName", nickName).getSingleResult()>0;
    }

    @Override
    public void delete(User user) {
        entityManager.remove(getById(user.getId()));
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
