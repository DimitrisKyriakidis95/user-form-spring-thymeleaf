package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> findAll() {

		return userRepository.findAll();
	}

	@Override
	public void save(User theUser) {
		userRepository.save(theUser);

	}

	@Override
	public User findById(int theId) {
		
		
		
		
		Optional<User> result = userRepository.findById(theId); 
		
		User theUser = null;
		
		if (result.isPresent()) {
			theUser = result.get();
		}
		else {
			
			throw new RuntimeException("Did not find employee id - " + theId);
		}
		
		return theUser;
		
		
	}

	@Override
	public void deleteById(int theId) {
		userRepository.deleteById(theId);
		
	}





}
