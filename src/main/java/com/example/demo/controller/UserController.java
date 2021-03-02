package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

	
	private UserService userService;

	@Autowired
	public UserController(UserService userService) {

		this.userService = userService;
	}


	@GetMapping("/user")
	public List<User> findAll() {

		return userService.findAll();
	}

	@GetMapping("/")
	public String homePage() {
		return "homepage";
	}
	
	
	
	@GetMapping("/list")
	public String listUsers(Model theModel) {

		List<User> theUser = userService.findAll();

		theModel.addAttribute("users", theUser);

		return "list-users";

	}


	@GetMapping("/user-form")
	public String showUserForm(Model model) {

		model.addAttribute("user", new User());

		List<String> genderlist = Arrays.asList("Male", "Female");
		model.addAttribute("genderlist", genderlist);

		return "saveUsers";
	}
	
	
	
	@PostMapping("/save")
	public String saveUser(@Valid @ModelAttribute("user") User theUser,BindingResult bindingResult,Model model) {
     
		   if(bindingResult.hasErrors()) {
			
			List<String> genderlist = Arrays.asList("Male", "Female");
		    model.addAttribute("genderlist", genderlist);
			
			return "saveUsers";
		}
		
		
		userService.save(theUser);

		return "redirect:list";
	}

	
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("userId") int theId, Model theModel) {
					
		
		User theUser = userService.findById(theId);
		
		
		theModel.addAttribute("user", theUser);
		
		List<String> genderlist = Arrays.asList("Male", "Female");
		theModel.addAttribute("genderlist", genderlist);
		
		
		return "saveUsers";			
	}


	
	@GetMapping("/delete")
	public String delete(@RequestParam("userId") int theId) {
		
		
		userService.deleteById(theId);
		
		
		return "redirect:list";
		
	}
	
	
	
	


}