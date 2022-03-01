package com.codingdojo.loginregister.service;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.loginregister.entity.User;
import com.codingdojo.loginregister.entity.request.LoginUser;
import com.codingdojo.loginregister.repository.UserRepository;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User register(User newUser, BindingResult result) {
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
			return null;
		}
		
		Optional<User> isEmailTaken = userRepository.findByEmail(newUser.getEmail());
		Optional<User> isUsernameTaken = userRepository.findByUsername(newUser.getUsername());
		
		if (isEmailTaken.isPresent()) {
			result.rejectValue("email", "Matches", "The email is already taken!");
			return null;
		}
		
		if (isUsernameTaken.isPresent()) {
			result.rejectValue("username", "Matches", "The username is already taken!");
			return null;
		}
		
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashed);
		
		return userRepository.save(newUser);
	}

	@Override
	public User login(LoginUser newLogin, BindingResult result) {
		Optional<User> potentialUser = userRepository.findByEmail(newLogin.getEmail());
		
		if (!potentialUser.isPresent() || !BCrypt.checkpw(newLogin.getPassword(), potentialUser.get().getPassword())) {
			result.rejectValue("email", "Matches", "Email / Password not valid");
			result.rejectValue("password", "Matches", "Email / Password not valid");
			return null;
		}
		
		return potentialUser.get();
	}
}
