package com.springapp.mvc.repositories;

import com.springapp.mvc.model.entity.User;

import java.util.List;

/**
 * @version 1.0
 * @autor a2driano
 * @project: ChatForFun
 * @since 05.01.2016
 */
public class UserRepositoryImpl implements UserRepository {
    @Override
    public User getByUser(String nickName, String password) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void add(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public List<User> getByOnline(User user) {
        return null;
    }
}
