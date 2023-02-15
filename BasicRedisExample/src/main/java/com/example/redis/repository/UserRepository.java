package com.example.redis.repository;

import java.util.List;

import com.example.redis.entities.User;

public interface UserRepository {

	boolean saveUser(User user);

    List<User> fetchAllUser();

    User fetchUserById(Long id);

    boolean deleteUser(Long id);

    boolean updateUser(Long id, User user);
}
