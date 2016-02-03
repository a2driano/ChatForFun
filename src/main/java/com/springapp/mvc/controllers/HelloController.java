package com.springapp.mvc.controllers;

import com.springapp.mvc.model.entity.User;
import com.springapp.mvc.model.web.UserDTO;
import com.springapp.mvc.model.web.UserResponce;
import com.springapp.mvc.model.web.UserResponceStatus;
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
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


/**
 * @version 1.0
 * @autor a2driano
 * @project: ChatForFun
 * @since 04.01.2016
 */

@Controller
public class HelloController {

//	@Autowired
//	private AuthenticationManager authMgr;

//	@Autowired
//	private UserDetailsServiceImpl UserDetailsServiceImpl;


    @Autowired
    private UserService userService;
//	@Autowired
//	private MessageHistoryService messageHistoryService;

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/registration")
    public String registration() {
        return "registration";
    }

//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	public ModelAndView getLoginPage(@RequestParam Optional<String> error) {
//		return new ModelAndView("login", "error", request.getSession().getAttribute("SPRING_SECURITY_LAST_EXCEPTION").toString());
//	}

    @RequestMapping(value = "/login")
    public String login(Model model) {
        return "login";
    }


    @RequestMapping(value = "/chat")
    public String chat() {
        return "chat";
    }

//	@RequestMapping(value = "/chatuser")
//	@ResponseBody
//	public UserDTO personalCabinet(HttpServletRequest request){
//		Principal principal = request.getUserPrincipal();
//		return userService.getUserByName(principal.getName());
//	}

//	@ResponseBody
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public UserDTO getByUser(@RequestParam String nickName, @RequestParam String password){
//		return userService.getByUser(nickName, password);
//	}

//	@ResponseBody
//	@RequestMapping(value = "/enter", method = RequestMethod.POST)
//	public UserDTO getByUserNickName(@RequestParam String nickName){
//		return userService.getByUserNickName(nickName);
//	}

    @ResponseBody
    @RequestMapping(value = "/del", method = RequestMethod.GET)
    public UserDTO deleteUser(@RequestParam int id) {
        return userService.deleteUser(id);
    }


    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView handleUserCreateForm(HttpServletRequest request) {
//        ModelAndView modelAndView = new ModelAndView("redirect:/chat");
        ModelAndView modelAndView = new ModelAndView();
        UserDTO userDTO = new UserDTO();
        userDTO.setNickName(request.getParameter("name")).setPasswordUser(request.getParameter("password"));
        UserResponce userResponce = userService.create(userDTO);
        if(userResponce==null) {
            modelAndView.setViewName("/registrationerr");
        }
        else if (userResponce.getUserResponceStatus() == UserResponceStatus.SUCCESS) {
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