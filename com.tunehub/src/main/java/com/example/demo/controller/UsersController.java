package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entities.Users;
import com.example.demo.services.UsersService;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class UsersController {

	@Autowired
	UsersService service;
	
	@PostMapping("/register")
	public String addUser (@ModelAttribute Users user
	){
		boolean userStatus=service.emailExists(user.getEmail());
		if(userStatus == false) {
		service.addUSer(user);
		System.out.println("User added");
		}
		else {
			System.out.println("User already exists");
		}
		return "home";
	}
	
	@PostMapping("/validate")
	public String validate(@RequestParam("email") String email,
			@RequestParam("password") String password) {
		
		if(service.validateUser(email,password)== true) 
		{
			String role=service.getRole(email);
			if(role.equals("admin")) {
				return "adminHome";
			}
			else {
				return "customerHome";
			}
		}
		else {
			return "login";
		}
	}
	
	
}
