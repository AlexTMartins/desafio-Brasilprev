package com.alex.challenge.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alex.challenge.model.v1.User;
import com.alex.challenge.service.UserService;

import lombok.Setter;

@RestController
@Setter
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/v1/users/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> GetById(@PathVariable(value = "id") long id) {

		Optional<User> optUser = userService.getById(id);
		
		if (optUser.isPresent()) {
			return new ResponseEntity<User>(optUser.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
