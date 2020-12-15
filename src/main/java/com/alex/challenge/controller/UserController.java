package com.alex.challenge.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alex.challenge.model.v1.User;
import com.alex.challenge.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/v1/users/{id}")
	public ResponseEntity<User> getById(@PathVariable(value = "id") Long id) {

		Optional<User> optUser = userRepository.findById(id);
		
		if (optUser.isPresent()) {
			return new ResponseEntity<User>(optUser.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/v1/users/")
	public User post(@RequestBody User user) {
	    return userRepository.save(user);
	}

    @PutMapping("/v1/users/{id}")
    public ResponseEntity<User> put(@PathVariable(value = "id") Long id, @RequestBody User newUser)
    {
        Optional<User> oldUser = userRepository.findById(id);
        if(oldUser.isPresent()){
            User user = oldUser.get();
            user.setName(newUser.getName());
            user.setDocument(newUser.getDocument());
            user.setAddress(newUser.getAddress());
            
            userRepository.save(user);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }
        else {
        	return new ResponseEntity<>(HttpStatus.NOT_FOUND);        	
        }
    }


    @DeleteMapping("/v1/users/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") Long id){
    	Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
        	userRepository.delete(user.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {        	
        	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
