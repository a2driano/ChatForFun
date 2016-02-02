package com.springapp.mvc.controllers;

import com.springapp.mvc.model.UserCreateForm;
import com.springapp.mvc.model.entity.User;
import com.springapp.mvc.model.web.MessageHistoryDTO;
import com.springapp.mvc.model.web.UserDTO;
import com.springapp.mvc.model.web.UserResponce;
import com.springapp.mvc.services.MessageHistoryService;
import com.springapp.mvc.services.UserDetailsServiceImpl;
import com.springapp.mvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.savedrequest.SavedRequest;

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
        ModelAndView modelAndView = new ModelAndView("redirect:/chat");
        UserDTO userDTO = new UserDTO();
        userDTO.setNickName(request.getParameter("name")).setPasswordUser(request.getParameter("password"));
        User user = userService.create(userDTO);

        List<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
        auth.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return "USER";
            }
        });
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getNickName(), user.getPasswordUser(), auth);
        SecurityContextHolder.getContext().setAuthentication(token);

        Authentication auth2 = SecurityContextHolder.getContext().getAuthentication();
        String name = auth2.getName();
        System.err.println(name);
        System.err.println(name);
        System.err.println(name);
        System.err.println(name);

//		modelAndView.addObject("Message", str);
        return modelAndView;
    }

}