package com.alex.challenge.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.alex.challenge.model.v1.User;
import com.alex.challenge.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public Optional<User> getById(Long id) {
		Optional<User> optUser = userRepository.findById(id);
		 return optUser;
	}
	
}
