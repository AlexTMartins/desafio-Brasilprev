package com.alex.challenge.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alex.challenge.model.v1.User;

@RestController
public class UserController {

	   @RequestMapping(value = "/v1/users/{id}", method = RequestMethod.GET)
	    public ResponseEntity<User> GetById(@PathVariable(value = "id") long id)
	    {
		   User user = User.builder().name("Alex").document("12332112300").build();
		   if(true) {			   
			   return new ResponseEntity<User>(user , HttpStatus.OK);
		   }else {
			   return new ResponseEntity<>(HttpStatus.NOT_FOUND);			   
		   }
	    }
}
