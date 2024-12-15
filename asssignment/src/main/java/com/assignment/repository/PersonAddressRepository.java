package com.assignment.repository;

import com.assignment.entity.PersonAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonAddressRepository extends JpaRepository<PersonAddress, Integer> {
}