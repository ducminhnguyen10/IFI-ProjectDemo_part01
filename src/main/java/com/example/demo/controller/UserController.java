package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("entity")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping(value="/user")
	public ResponseEntity<List<User>> findAllUser(){
		List<User> users = userService.findAllUser();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
}
