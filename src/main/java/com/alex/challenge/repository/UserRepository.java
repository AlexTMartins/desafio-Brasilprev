package com.alex.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alex.challenge.model.v1.User;


public interface UserRepository extends JpaRepository<User, Long> {

    public User findUserByNameAndDocument(String name, String doc);
}