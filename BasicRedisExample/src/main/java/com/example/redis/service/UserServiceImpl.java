package com.example.redis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.redis.entities.User;
import com.example.redis.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public boolean saveUser(User user) {
		  return userRepository.saveUser(user);
	}

	@Override
	public List<User> fetchAllUser() {
		 return userRepository.fetchAllUser();
	}

	@Override
	public User fetchUserById(Long id) {
		 return userRepository.fetchUserById(id);
	}

	@Override
	public boolean deleteUser(Long id) {
		return userRepository.deleteUser(id);
	}

	@Override
	public boolean updateUser(Long id, User user) {
		return userRepository.updateUser(id,user);
	}

}
