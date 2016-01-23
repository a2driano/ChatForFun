package com.springapp.mvc.services;

import com.springapp.mvc.model.entity.User;
import com.springapp.mvc.model.web.UserDTO;
import com.springapp.mvc.model.web.UserResponce;

import java.util.List;

/**
 * @version 1.0
 * @autor a2driano
 * @project: ChatForFun
 * @since 05.01.2016
 */
public interface UserService {

    UserDTO getUserByName(String nickname);

    /**
     * This methods returns a user by nickname
     * @param userDTO
     * @return
     */
    UserResponce enterUser(UserDTO userDTO);

    /**
     * This methods returns a user by nickname and password
     * @param userDTO
     * @return
     */
    UserResponce confirmUser(UserDTO userDTO);

    /**
     * This methods returns all users in DB
     * @return
     */
    List<UserDTO> getAll();

    /**
     * This methods returns all users who is online
     * @return
     */
    List<UserDTO> getByOnline();
    /**
     * This methods add user into DB
     * @param  userDTO
     * @return
     */
    UserResponce addUser(UserDTO userDTO);

    /**
     * This methods delete user into DB
     * @param  id
     * @return
     */
    UserDTO deleteUser(Integer id);

    /**
     * This methods update user in DB
     * @param userDTO
     * @return
     */
    UserDTO updateUser(UserDTO userDTO);
}
