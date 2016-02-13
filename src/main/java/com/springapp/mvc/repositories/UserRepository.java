package com.springapp.mvc.repositories;

import com.springapp.mvc.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @version 1.0
 * @autor a2driano
 * @project: ChatForFun
 * @since 05.01.2016
 */
public interface UserRepository {

    /**
     * return name concrete user
     *
     * @param id
     * @return
     */
    Object getNameUserById(Integer id);

    /**
     * return user by name and password
     *
     * @param nickName
     * @param password
     * @return
     */
    User getByUser(String nickName, String password);

    /**
     * return user by name
     *
     * @param nickName
     * @return
     */
    User getByName(String nickName);

    /**
     * return all users
     *
     * @return
     */
    List getAll();

    /**
     * return user by id
     *
     * @param id
     * @return
     */
    User getById(Integer id);

    /**
     * delete user
     *
     * @param user
     */
    void delete(User user);

    /**
     * add user
     *
     * @param user
     */
    void add(User user);

    /**
     * update user
     *
     * @param user
     */
    void update(User user);

    /**
     * ger users hwo online
     *
     * @return
     */
    List<User> getByOnline();
}
