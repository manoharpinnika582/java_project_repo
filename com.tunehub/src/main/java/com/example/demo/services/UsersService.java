package com.example.demo.services;

import com.example.demo.entities.Users;

public interface UsersService {
	public String addUSer(Users user);
	public boolean emailExists(String email);
	public boolean validateUser(String email,String password);
	public String getRole(String email);
}
