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

//    @Autowired
//    private MessageHistoryRepository messageHistoryRepository;

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Override
    public UserDTO getUserByName(String nickname){
        UserDTO userDTO=new UserDTO();
        User user=userRepository.getByName(nickname);
        userDTO.setNickName(user.getNickName()).setId(user.getId());
        return userDTO;
    }

    @Override
    public UserResponce create(UserDTO userDTO) {
        UserResponce userResponce=new UserResponce();
        User user = new User();
        user.setNickName(userDTO.getNickName());
        user.setPasswordUser(new BCryptPasswordEncoder(12).encode(userDTO.getPasswordUser()));
        user.setUserRole(UserRole.USER);
        try{
            userRepository.add(user);
//            return "Регистрация прошла успешно";
        }
//        catch (ConstraintViolationException e){
//            LOGGER.error("{}",e.toString(),e);
//            return userResponce.setUserResponceStatus(UserResponceStatus.FAIL);
////            return "Данное имя уже используется";
//        }
        catch (Exception e){
            LOGGER.error("{}",e.toString(),e);
            return null;
        }
        return userResponce.setUserResponceStatus(UserResponceStatus.SUCCESS).setUserDTO(userDTO);
    }

//    try{
//        user=userRepository.getByUser(userDTO.getNickName(),userDTO.getPasswordUser());
//        return userResponce.setUserResponceStatus(UserResponceStatus.FAIL).setMessage("Этот логин уже занят, выберите другой");
//    }catch (EmptyResultDataAccessException e){
//        LOGGER.error("{}", e.toString(), e);
//        userRepository.add(user.setNickName(userDTO.getNickName()).setPasswordUser(userDTO.getPasswordUser()));
//        return userResponce.setUserResponceStatus(UserResponceStatus.SUCCESS)
//                .setUserDTO(userDTO)
//                .setMessage("chat.ftl");
////                    .setMessage("Регистрация прошла успешно! Вы вошли под ником: " + userDTO.getNickName());
//    }


//    @Override
//    public UserResponce create(UserDTO userDTO) {
//        UserResponce userResponce=new UserResponce();
//        User user = new User();
//        user.setNickName(userDTO.getNickName());
//        user.setPasswordUser(userDTO.getPasswordUser());
//        user.setUserRole(UserRole.USER);
//        try{
//            userRepository.add(user);
////            return "Регистрация прошла успешно";
//        }catch (ConstraintViolationException e){
//            LOGGER.error("{}",e.toString(),e);
//            return userResponce.setUserResponceStatus(UserResponceStatus.FAIL);
////            return "Данное имя уже используется";
//        }
//        catch (Exception e){
//            LOGGER.error("{}",e.toString(),e);
//            return null;
//        }
//        return userResponce.setUserResponceStatus(UserResponceStatus.SUCCESS).setUserDTO(userDTO);
//    }


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
    public UserResponce confirmUser(UserDTO userDTO) {
        UserResponce userResponce=new UserResponce();
        User user=new User();
        //name and password must be not null
        if((userDTO.getNickName())==""||(userDTO.getPasswordUser())==""){
            return userResponce.setUserResponceStatus(UserResponceStatus.FAIL).setMessage("Необходимо заполнить все поля! Повторите пожалуйста!");
        }
        try{
            user=userRepository.getByUser(userDTO.getNickName(),userDTO.getPasswordUser());
            return userResponce.setUserResponceStatus(UserResponceStatus.SUCCESS)
                    .setUserDTO(userDTO)
                    .setMessage(user.getNickName()+", Вы вошли в свой аккаунт");
        }catch (EmptyResultDataAccessException e){
            LOGGER.error("{}", e.toString(), e);

            return userResponce.setUserResponceStatus(UserResponceStatus.FAIL).setMessage("Неверный логин или пароль");
        } catch (Exception e) {
            LOGGER.error("{}", e.toString(), e);
            return userResponce.setUserResponceStatus(UserResponceStatus.FAIL).setMessage("Нет соединения с базой данных");
        }
    }

    //update this class
    @Override
    public UserResponce enterUser(UserDTO userDTO) {
        UserResponce userResponce=new UserResponce();
        User user=new User();
        //name and password must be not null
        if((userDTO.getNickName())==""){
            return userResponce.setUserResponceStatus(UserResponceStatus.FAIL).setMessage("Необходимо заполнить поле!");
        }
        try{
            userRepository.getByName(userDTO.getNickName());
            return userResponce.setUserResponceStatus(UserResponceStatus.FAIL).setMessage("Этот логин уже занят, выберите другой");
        }catch (EmptyResultDataAccessException e){
            LOGGER.error("{}", e.toString(), e);
            userRepository.add(user.setNickName(userDTO.getNickName()).setPasswordUser(userDTO.getPasswordUser()));
            return userResponce.setUserResponceStatus(UserResponceStatus.SUCCESS)
                    .setUserDTO(userDTO)
                    .setMessage("Вы вошли под ником: " + userDTO.getNickName());
        } catch (Exception e) {
            LOGGER.error("{}", e.toString(), e);
            return userResponce.setUserResponceStatus(UserResponceStatus.FAIL).setMessage("Нет соединения с базой данных");
        }
    }

    @Override
    public UserResponce addUser(UserDTO userDTO){
        UserResponce userResponce=new UserResponce();
        User user=new User();
        //name and password must be not null
        if((userDTO.getNickName())==""||(userDTO.getPasswordUser())==""){
            return userResponce.setUserResponceStatus(UserResponceStatus.FAIL).setMessage("Необходимо заполнить все поля! Повторите пожалуйста!");
        }
        try{
            user=userRepository.getByUser(userDTO.getNickName(),userDTO.getPasswordUser());
            return userResponce.setUserResponceStatus(UserResponceStatus.FAIL).setMessage("Этот логин уже занят, выберите другой");
        }catch (EmptyResultDataAccessException e){
            LOGGER.error("{}", e.toString(), e);
            userRepository.add(user.setNickName(userDTO.getNickName()).setPasswordUser(userDTO.getPasswordUser()));
            return userResponce.setUserResponceStatus(UserResponceStatus.SUCCESS)
                    .setUserDTO(userDTO)
                    .setMessage("chat.ftl");
//                    .setMessage("Регистрация прошла успешно! Вы вошли под ником: " + userDTO.getNickName());
        } catch (Exception e) {
            LOGGER.error("{}", e.toString(), e);
            return userResponce.setUserResponceStatus(UserResponceStatus.FAIL).setMessage("Нет соединения с базой данных");
        }
    }

//    @Override
//    public UserResponce addUser(UserDTO userDTO) {
//        UserResponce userResponce=new UserResponce();
//        User user=new User();
//        //name and password must be not null
//        if((userDTO.getNickName())==""||(userDTO.getPasswordUser())==""){
//            return userResponce.setUserResponceStatus(UserResponceStatus.FAIL).setMessage("Необходимо заполнить все поля! Повторите пожалуйста!");
//        }
//        try{
//            if(userRepository.isPresent(userDTO.getNickName())){
//                return userResponce.setUserResponceStatus(UserResponceStatus.FAIL).setMessage("Этот логин уже занят, выберите другой");
//            }else {
//                userRepository.add(user.setNickName(userDTO.getNickName()).setPasswordUser(userDTO.getPasswordUser()));
//                return userResponce.setUserResponceStatus(UserResponceStatus.SUCCESS)
//                        .setUserDTO(userDTO)
//                        .setMessage("Регистрация прошла успешно! Вы вошли под ником: "+userDTO.getNickName());
//            }
//        }catch (Exception e){
//            LOGGER.error("{}", e.toString(), e);
//            return userResponce.setUserResponceStatus(UserResponceStatus.FAIL).setMessage("Нет соединения с базой данных");
//        }
//    }

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
