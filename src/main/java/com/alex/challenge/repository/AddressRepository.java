package com.alex.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alex.challenge.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}