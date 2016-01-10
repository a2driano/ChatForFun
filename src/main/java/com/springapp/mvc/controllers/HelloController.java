package com.springapp.mvc.controllers;

import com.springapp.mvc.model.web.UserDTO;
import com.springapp.mvc.model.web.UserResponce;
import com.springapp.mvc.services.MessageHistoryService;
import com.springapp.mvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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



}