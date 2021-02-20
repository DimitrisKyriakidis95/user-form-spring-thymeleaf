package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.User;

public interface UserService {

	public List<User> findAll();

	public void save(User theUser);

	public User findById(int theId);
	
	public void deleteById(int theId);
	
	
	
}
