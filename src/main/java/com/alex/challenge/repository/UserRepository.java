package com.alex.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.alex.challenge.model.v1.User;

@RepositoryRestResource(path = "users")
public interface UserRepository extends JpaRepository<User, Long> {

    public User findUserByNameAndDocument(String name, String doc);
}