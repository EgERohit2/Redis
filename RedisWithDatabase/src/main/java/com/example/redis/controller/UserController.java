package com.example.redis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.redis.entities.Users;
import com.example.redis.service.UserService;

@RestController
@RequestMapping("/redis")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public List<Users> getAllData() {
		return this.userService.getData();
	}

	@PostMapping("/post")
	public String postAllData(@RequestBody Users users) {
		this.userService.postData(users);
		return "data posted successfully";
	}

	@GetMapping("/{id}")
	@Cacheable(value ="users", key = "#id",unless="#result.id<5")
	public Users getAllDataById(@PathVariable Long id) {
		
		Users users=userService.getDataById(id);
		return users;

	}
	
	@DeleteMapping("/{id}")
	public String deleteAllDataById(@PathVariable Long id) {
		this.userService.deleteById(id);
		return "deleted";
	}

}
