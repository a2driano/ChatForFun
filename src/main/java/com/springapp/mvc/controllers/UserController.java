package com.springapp.mvc.controllers;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.springapp.mvc.model.web.UserDTO;
import com.springapp.mvc.model.web.UserResponce;
import com.springapp.mvc.model.web.UserResponceStatus;
import com.springapp.mvc.services.MessageHistoryService;
import com.springapp.mvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @autor a2driano
 * @project: ChatForFun
 * @since 09.01.2016
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/getName", method = RequestMethod.GET)
    public String getName() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        System.err.println(name);
        return name;
    }

    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView handleUserCreateForm(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        UserDTO userDTO = new UserDTO();
        userDTO.setNickName(request.getParameter("name")).setPasswordUser(request.getParameter("password"));
        UserResponce userResponce = userService.create(userDTO);
        if (userResponce == null) {
            modelAndView.setViewName("/registrationerr");
        } else if (userResponce.getUserResponceStatus() == UserResponceStatus.SUCCESS) {
            List<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
            auth.add(new GrantedAuthority() {
                @Override
                public String getAuthority() {
                    return "USER";
                }
            });
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDTO.getNickName(), userDTO.getPasswordUser(), auth);
            SecurityContextHolder.getContext().setAuthentication(token);
            modelAndView.setViewName("redirect:/chat");
        }
        return modelAndView;
    }
}
