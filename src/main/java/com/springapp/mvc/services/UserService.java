package com.springapp.mvc.services;

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


    /**
     * return user by his name
     *
     * @param nickname
     * @return
     */
    UserDTO getUserByName(String nickname);

    /**
     * Create new user
     *
     * @param userDTO
     * @return
     */

    UserResponce create(UserDTO userDTO);

    /**
     * get all user from DB
     *
     * @return
     */
    List<UserDTO> getAll();

    /**
     * This methods returns all users who is online
     *
     * @return
     */
    List<UserDTO> getByOnline();

    /**
     * This methods delete user into DB
     *
     * @return
     */
    void deleteUser(Integer id);

    /**
     * This methods update user in DB
     *
     * @param userDTO
     * @return
     */
    UserDTO updateUser(UserDTO userDTO);
}
