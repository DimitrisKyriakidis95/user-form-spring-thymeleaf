package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	private UserService userService;

	
	@Autowired
	public UserController(UserService userService) {
	
		this.userService = userService;
	}

@GetMapping("/user")
public List<User> findAll(){
	return userService.findAll();
}







}
