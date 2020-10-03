package com.maurcio.ccasani.app_rest_jwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maurcio.ccasani.app_rest_jwt.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
	public User findByUsername(String username);
}
