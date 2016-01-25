package com.springapp.mvc.controllers;

import com.springapp.mvc.model.UserCreateForm;
import com.springapp.mvc.model.web.UserDTO;
import com.springapp.mvc.model.web.UserResponce;
import com.springapp.mvc.services.MessageHistoryService;
import com.springapp.mvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

/**
 * @version 1.0
 * @autor a2driano
 * @project: ChatForFun
 * @since 04.01.2016
 */

@Controller
public class HelloController {
	@Autowired
	private UserService userService;
	@Autowired
	private MessageHistoryService messageHistoryService;

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
	public String login(Model model){
		return "login";
	}

//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	public ModelAndView login(
//			@RequestParam(value = "error", required = false) String error) {
//		ModelAndView model = new ModelAndView();
//		if (error != null) {
//			model.addObject("error", "Invalid username and password!");
//		}
//		model.setViewName("login");
//		return model;
//	}

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
	public UserDTO deleteUser(@RequestParam int id){
		return userService.deleteUser(id);
	}

//	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView handleUserCreateForm(HttpServletRequest request) {
		ModelAndView modelAndView=new ModelAndView("redirect:/registration");
		UserDTO userDTO=new UserDTO();
		userDTO.setNickName(request.getParameter("name")).setPasswordUser(request.getParameter("password"));
		String str=userService.create(userDTO);

		modelAndView.addObject("Message", str);
		return modelAndView;
	}

//	//	@ResponseBody
//	@RequestMapping(value = "/save", method = RequestMethod.POST)
//	public String handleUserCreateForm(HttpServletRequest request) {
//		UserDTO userDTO=new UserDTO();
//		userDTO.setNickName(request.getParameter("name")).setPasswordUser(request.getParameter("password"));
//		userService.create(userDTO);
////		return "redirect:/";
//		return "/registration";
//	}



}