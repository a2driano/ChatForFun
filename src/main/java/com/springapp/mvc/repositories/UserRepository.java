package com.springapp.mvc.repositories;

import com.springapp.mvc.model.entity.User;

import java.util.List;

/**
 * @version 1.0
 * @autor a2driano
 * @project: ChatForFun
 * @since 05.01.2016
 */
public interface UserRepository {

    User getByUser(String nickName, String password);

    List<User> getAll();

    void delete(User user);

    void add(User user);

    void update(User user);

    List<User> getByOnline(User user);
}
