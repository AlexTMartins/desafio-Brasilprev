package com.alex.challenge.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.alex.challenge.model.User;
import com.alex.challenge.repository.UserRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void insertUser() {
    	
        User user = User.builder().id(1L).name("Alex").document("12345678900").build();
        userRepository.save(user);
        Integer countUser = userRepository.findAll().size();
        assertEquals(1, countUser);
    }

    @Test
    public void checkUserSavedWithDocument() {
    	User user = User.builder().id(1L).name("Alex").document("12345678900").build();
        userRepository.save(user);
        Integer countUser = userRepository.findAll().size();
        assertEquals(1, countUser);
        User user1 = userRepository.findUserByNameAndDocument("name", "12345678900");

        assertNotNull(user1);
        assertEquals(user, user1);
    }

    @Test
    public void checkUserSavedWithDocumentPassingOtherDocumentShouldReturnNull() {
    	User user = User.builder().id(1L).name("Alex").document("12345678900").build();
        userRepository.save(user);
        Integer countUser = userRepository.findAll().size();
        assertEquals(1, countUser);
        User user1 = userRepository.findUserByNameAndDocument("Alex", "12345678901");

        assertNull(user1);
    }
}
