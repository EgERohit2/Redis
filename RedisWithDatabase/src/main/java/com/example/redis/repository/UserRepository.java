package com.example.redis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.redis.entities.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

	

	

}
