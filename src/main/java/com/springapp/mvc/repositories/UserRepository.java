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
public interface UserRepository{

    Object getNameUserById(Integer id);

    User getByUser(String nickName, String password);

    User getByName(String nickName);

    List getAll();

    User getById (Integer id);

    Boolean isPresent(String nickName);

    Boolean isPresentConfirm(String nickName, String passwordUser);

    void delete(User user);

    void add(User user);

    User save(User user);

    void update(User user);

    List<User> getByOnline();
}
