package com.codingdojo.loginregister.service;

import org.springframework.validation.BindingResult;

import com.codingdojo.loginregister.entity.User;
import com.codingdojo.loginregister.entity.request.LoginUser;

public interface IUserService {
	public abstract User register(User newUser, BindingResult result);
	public abstract User login (LoginUser newLogin, BindingResult result);
}
