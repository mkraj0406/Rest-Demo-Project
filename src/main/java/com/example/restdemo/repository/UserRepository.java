package com.example.restdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restdemo.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
