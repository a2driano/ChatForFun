package com.springapp.mvc.services;

import com.springapp.mvc.model.entity.User;
import com.springapp.mvc.model.web.UserDTO;

import java.util.List;

/**
 * @version 1.0
 * @autor a2driano
 * @project: ChatForFun
 * @since 05.01.2016
 */
public interface UserService {

    /**
     * This methods returns a user by nickname
     * @param nickName
     * @return
     */
    UserDTO getByUserNickName(String nickName);

    /**
     * This methods returns a user by nickname and password
     * @param nickName
     * @param password
     * @return
     */
    UserDTO getByUser(String nickName, String password);

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
     * @param userDTO
     * @return
     */
    UserDTO addUser(UserDTO userDTO);

    /**
     * This methods delete user into DB
     * @param userDTO
     * @return
     */
    UserDTO deleteUser(UserDTO userDTO);

    /**
     * This methods update user in DB
     * @param userDTO
     * @return
     */
    UserDTO updateUser(UserDTO userDTO);
}
