package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	private User user;
	
//	Get all users
	public List<User> findAllUser(){
		return userRepository.findAll();
	}
//	Get user by Id
	public Optional<User> findUserById(int userId){
		return userRepository.findById(userId);
	}
	
//	Add user
	public boolean addUser(User user) {
		User users = new User(user.getUserId(), user.getDayBirth(), user.getUserAddress(), user.getUserName());
		if (userRepository.save(users)!=null) {
			return true;
		}
		return false;
	}
	
//	Edit user
	public boolean editUser(User user) {
		User userEdit = new User(user.getUserId(), user.getDayBirth(), user.getUserAddress(), user.getUserName());
		userEdit.setUserId(user.getUserId());
		if (userRepository.save(userEdit)!=null) {
			return true;
		}
		return false;
	}
	
//	Delete user
	public boolean deleteUser(int userId) {
		if (this.findUserById(userId)!=null) {
			userRepository.deleteById(userId);
			return true;
		}
		return false;
	}
}
