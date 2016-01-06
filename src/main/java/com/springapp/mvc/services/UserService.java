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

    UserDTO getByUserNickName(String nickName);

    UserDTO getByUser(String nickName, String password);

    List<UserDTO> getAll();

    List<UserDTO> getByOnline();

    UserDTO addUser(UserDTO userDTO);

    UserDTO deleteUser(UserDTO userDTO);

    UserDTO updateUser(UserDTO userDTO);
}
