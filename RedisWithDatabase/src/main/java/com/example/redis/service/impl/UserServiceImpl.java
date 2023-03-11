package com.example.redis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.example.redis.entities.Users;
import com.example.redis.repository.UserRepository;
import com.example.redis.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private RedisTemplate redisTemplate;

	private static final String KEY = "USERS";

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<Users> getData() {

		List<Users> users;
		users = redisTemplate.opsForHash().values(KEY);
		return users;
	}

	@Override
	public Users postData(Users users) {
		redisTemplate.opsForHash().put(KEY, users.getId().toString(), users);

		return userRepository.save(users);
	}

	@Override
	public Users getDataById(Long id) {
	//	User user =  userRepository.findById(id).orElseThrow();
		Users users = (Users)redisTemplate.opsForHash().get(KEY,id.toString());
		return users;
	}

	@Override
	public void updateDataById(Long id,Users users) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		this.userRepository.deleteById(id);
		
		
	}

//	@Override
//	public User getDataById(Long id) {
//		User user=userRepository.findById(id);
//		user= redisTemplate.opsForHash().values(KEY);
//		return (User) userRepository.findAll();
//	}

//	@Override
//	public List<Object> updateById(User user, Long id) {
//		// TODO Auto-generated method stub
//		List<Object> us = userRepository.findById(id);
//		return us;
//		
//	}

	

}
