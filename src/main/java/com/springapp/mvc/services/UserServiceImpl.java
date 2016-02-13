package com.springapp.mvc.services;

import com.springapp.mvc.model.entity.User;
import com.springapp.mvc.model.entity.UserRole;
import com.springapp.mvc.model.web.UserDTO;
import com.springapp.mvc.model.web.UserResponce;
import com.springapp.mvc.model.web.UserResponceStatus;
import com.springapp.mvc.repositories.UserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @autor a2driano
 * @project: ChatForFun
 * @since 05.01.2016
 */
@Service
public class UserServiceImpl implements UserService {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO getUserByName(String nickname) {
        UserDTO userDTO = new UserDTO();
        try {
            User user = userRepository.getByName(nickname);
            userDTO.setNickName(user.getNickName()).setId(user.getId());
        } catch (Exception e) {
            LOGGER.error("{}", e.toString(), e);
            return null;
        }
        return userDTO;
    }

    @Override
    public UserResponce create(UserDTO userDTO) {
        UserResponce userResponce = new UserResponce();
        User user = new User();
        user.setNickName(userDTO.getNickName());
        user.setPasswordUser(new BCryptPasswordEncoder(12).encode(userDTO.getPasswordUser()));
        user.setUserRole(UserRole.USER);
        try {
            userRepository.add(user);
        } catch (Exception e) {
            LOGGER.error("{}", e.toString(), e);
            return null;
        }
        return userResponce.setUserResponceStatus(UserResponceStatus.SUCCESS).setUserDTO(userDTO);
    }

    @Override
    public List<UserDTO> getAll() {
        List<UserDTO> userDTOList = new ArrayList<UserDTO>();
        try {
            List<User> users = userRepository.getAll();
            for (User user : users) {
                userDTOList.add(new UserDTO()
                                .setId(user.getId())
                                .setNickName(user.getNickName())
                                .setPasswordUser(user.getPasswordUser())
                                .setOnline(user.getOnline())
                );
            }
        } catch (Exception e) {
            LOGGER.error("{}", e.toString(), e);
        }
        return userDTOList;
    }

    @Override
    public List<UserDTO> getByOnline() {
        List<UserDTO> userDTOList = new ArrayList<UserDTO>();
        try {
            for (User user : userRepository.getByOnline()) {
                userDTOList.add(new UserDTO()
                        .setId(user.getId())
                        .setNickName(user.getNickName())
                        .setPasswordUser(user.getPasswordUser())
                        .setOnline(user.getOnline()));
            }

        } catch (Exception e) {
            LOGGER.error("{}", e.toString(), e);
        }

        return userDTOList;
    }

    @Override
    public void deleteUser(Integer id) {
        try {
            User user = new User().setId(id);
            userRepository.delete(user);
        } catch (Exception e) {
            LOGGER.error("{}", e.toString(), e);
        }
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        try {
            User user = new User();
            user.setId(userDTO.getId());
            user.setNickName(userDTO.getNickName());
            user.setPasswordUser(userDTO.getPasswordUser());
            user.setOnline(true);
            userRepository.update(user);
        } catch (Exception e) {
            LOGGER.error("{}", e.toString(), e);
        }
        return null;
    }
}
