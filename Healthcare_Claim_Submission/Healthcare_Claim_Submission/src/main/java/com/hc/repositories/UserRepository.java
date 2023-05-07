package com.hc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hc.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
