package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.User;

public interface UserRepo extends JpaRepository<User,Integer> {

	List<User> findByTech(String tech);
}
