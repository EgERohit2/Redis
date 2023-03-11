package com.example.redis.service;

import java.util.List;

import com.example.redis.entities.Users;

public interface UserService {

	public List<Users> getData();

	public Users postData(Users users);

	public Users getDataById(Long id);
	
	public void updateDataById(Long id,Users users);
	
	public void deleteById(Long id);
	
//	public List<Object> updateById(User user,Long id);

}
