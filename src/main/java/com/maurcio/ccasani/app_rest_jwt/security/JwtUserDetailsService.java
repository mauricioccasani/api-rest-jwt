package com.maurcio.ccasani.app_rest_jwt.security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.maurcio.ccasani.app_rest_jwt.dao.UserDao;
import com.maurcio.ccasani.app_rest_jwt.dto.UserDto;
import com.maurcio.ccasani.app_rest_jwt.entity.User;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=this.userDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User no  encontrado con  username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}
	
	public User save(UserDto user) {
		User newUser = new User();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		return this.userDao.save(newUser);//userDao.save(newUser);
	}

}
