package com.springapp.mvc.services;

import com.springapp.mvc.model.entity.User;
import com.springapp.mvc.model.web.UserDTO;
import com.springapp.mvc.model.web.UserResponce;
import com.springapp.mvc.model.web.UserResponceStatus;
import com.springapp.mvc.repositories.MessageHistoryRepository;
import com.springapp.mvc.repositories.UserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

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
    private MessageHistoryRepository messageHistoryRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO getByUserNickName(String nickName) {
        if(nickName==null){
            return null;
        }
        User user=new User();
        try {
            user = userRepository.getByName(nickName);
            if (user.getNickName() != null && user.getPasswordUser() != null) {
                return null;
            } else if (user.getNickName() != null && user.getPasswordUser() == null) {
                user.setOnline(true);
                userRepository.update(user);
            }
            user = userRepository.getByName(nickName);
            UserDTO userDTO = new UserDTO()
                    .setId(user.getId())
                    .setNickName(user.getNickName())
                    .setOnline(user.getOnline());
            return userDTO;
        } catch (Exception e) {
            LOGGER.error("{}", e.toString(), e);
            user.setNickName(nickName);
            user.setPasswordUser(null);
            user.setOnline(true);
            userRepository.add(user);
            user = userRepository.getByName(nickName);
            UserDTO userDTO = new UserDTO()
                    .setId(user.getId())
                    .setNickName(user.getNickName())
                    .setOnline(user.getOnline());
            return userDTO;
        }
    }

    @Override
    public UserDTO getByUser(String nickName, String password) {
        if(nickName==null&&password==null){
            return null;
        }
        User user=userRepository.getByUser(nickName, password);
        UserDTO userDTO = new UserDTO()
                .setId(user.getId())
                .setNickName(user.getNickName())
                .setOnline(user.getOnline())
                .setPasswordUser(user.getPasswordUser());

        return userDTO;
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
        }    catch (Exception e){
            LOGGER.error("{}",e.toString(),e);
        }
        return userDTOList;
    }

    @Override
    public List<UserDTO> getByOnline() {
        List<UserDTO> userDTOList=new ArrayList<UserDTO>();
        try{
            for(User user:userRepository.getByOnline()){
                userDTOList.add(new UserDTO()
                        .setId(user.getId())
                        .setNickName(user.getNickName())
                        .setPasswordUser(user.getPasswordUser())
                        .setOnline(user.getOnline()));
            }

        }catch (Exception e){
            LOGGER.error("{}",e.toString(),e);
        }

        return userDTOList;
    }

    @Override
    public UserResponce addUser(UserDTO userDTO) {
        UserResponce userResponce=new UserResponce();
        User user=new User();
        if((userDTO.getNickName())==""||(userDTO.getPasswordUser())==""){
            return userResponce.setUserResponceStatus(UserResponceStatus.FAIL).setMessage("Необходимо заполнить все поля! Повторите пожалуйста!");
        }
        try{
            if(userRepository.isPresent(userDTO.getNickName())){
                return userResponce.setUserResponceStatus(UserResponceStatus.FAIL).setMessage("Этот логин уже занят, выберите другой");
            }else {
                userRepository.add(user.setNickName(userDTO.getNickName()).setPasswordUser(userDTO.getPasswordUser()));
            }
        }catch (Exception e){
            LOGGER.error("{}", e.toString(), e);
            return userResponce.setUserResponceStatus(UserResponceStatus.FAIL).setMessage("Нет соединения с базой данных");
        }
        try{
            user=userRepository.getByUser(userDTO.getNickName(),userDTO.getPasswordUser());
            userDTO = new UserDTO()
                    .setId(user.getId())
                    .setNickName(user.getNickName())
                    .setOnline(user.getOnline())
                    .setPasswordUser(user.getPasswordUser());
            return userResponce.setUserResponceStatus(UserResponceStatus.SUCCESS)
                    .setUserDTO(userDTO)
                    .setMessage("Регистрация прошла успешно!");
        }
        catch (Exception e){
            LOGGER.error("{}", e.toString(), e);
            return userResponce.setUserResponceStatus(UserResponceStatus.FAIL).setMessage("User зарегистрирован, соединения с базой данных оборвалось...");
        }
    }

    @Override
    public UserResponce addUser2(String nickName, String password) {
        UserResponce userResponce=new UserResponce();
        try{
            User user=new User();
            user.setNickName(nickName);
            user.setPasswordUser(password);
            user.setOnline(true);
            userRepository.add(user);

            user=userRepository.getByUser(user.getNickName(), user.getPasswordUser());
            UserDTO userDTO = new UserDTO()
                    .setId(user.getId())
                    .setNickName(user.getNickName())
                    .setOnline(user.getOnline())
                    .setPasswordUser(user.getPasswordUser());

            return userResponce.setUserResponceStatus(UserResponceStatus.SUCCESS)
                    .setUserDTO(userDTO)
                    .setMessage("SUCCESS");

        }catch (Exception e){
            LOGGER.error("{}", e.toString(), e);
            return userResponce.setUserResponceStatus(UserResponceStatus.FAIL).setMessage(nickName + " --- " + password);
        }

    }

    @Override
    public UserDTO deleteUser(Integer id) {
        try{
            User user=new User().setId(id);
            userRepository.delete(user);
        }catch (Exception e){
            LOGGER.error("{}",e.toString(),e);
        }
        return null;
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        try{
            User user=new User();
            user.setId(userDTO.getId());
            user.setNickName(userDTO.getNickName());
            user.setPasswordUser(userDTO.getPasswordUser());
            user.setOnline(true);
            userRepository.update(user);
        }catch (Exception e){
            LOGGER.error("{}",e.toString(),e);
        }
        return null;
    }
}
