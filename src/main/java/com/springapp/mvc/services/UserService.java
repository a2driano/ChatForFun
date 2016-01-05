package com.springapp.mvc.services;

import com.springapp.mvc.model.entity.User;

import java.util.List;

/**
 * @version 1.0
 * @autor a2driano
 * @project: ChatForFun
 * @since 05.01.2016
 */
public interface UserService {

    User getByUser(String nickName, String password);

    List<User> getAll();

    List<User> getByOnline();
}
