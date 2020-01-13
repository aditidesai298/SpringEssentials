package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.User;
import com.example.demo.dao.UserRepo;

@RestController
public class UserController {

	@Autowired
	UserRepo repo;

	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	
//	@DeleteMapping("/user{id}")
//	public String deleteUser (@PathVariable int id)
//	{
//		User u=repo.getOne(id);
//		return "deleted";
//		
//	}

	@PostMapping("/user")
	public User addUser(@RequestBody User user) {

		repo.save(user);
		return user;
	}
//	@RequestMapping("/getUser")
//	public ModelAndView getUser(@RequestParam int id) {
//		ModelAndView mv=new ModelAndView("showUser.jsp");
//		User user=repo.findById(id).orElse(new User());
//		mv.addObject(user);
//		return mv;
//		
//	}
	@DeleteMapping("/user/{id}")
	public String deleteUser(@PathVariable int id)
	{
		User u=repo.getOne(id);
		repo.delete(u);
		return "deleted user";
	}
	
	@GetMapping(path="/users")
	@ResponseBody
	public List<User> getUsers() {
	
		return repo.findAll();
		
	}
	@PutMapping(path="/user",consumes= {"application/json"})
	public User updateUser(@RequestBody User user)
	{
		repo.save(user);
		return user;
	}
//	@RequestMapping("/users/{id}")
//	@ResponseBody
//	public String getUser1 (@PathVariable("id") int id) {
//	
//		return repo.findById(id).toString();
//		
//	}
	
	@RequestMapping("/users/{id}")
	@ResponseBody
	public Optional <User> getUser (@PathVariable("id") int id) {
	
		return repo.findById(id);
		
	}
	
}
