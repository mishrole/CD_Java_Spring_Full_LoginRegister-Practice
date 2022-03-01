package com.codingdojo.loginregister.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.loginregister.entity.User;
import com.codingdojo.loginregister.entity.request.LoginUser;
import com.codingdojo.loginregister.service.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "index";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "index";
		}
		
		User savedUser = userService.register(newUser, result);
		if (savedUser == null) {
			model.addAttribute("newLogin", new LoginUser());
			return "index";
		}
		
		session.setAttribute("user", savedUser);
		
		return "redirect:/home";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {
		if(result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "index";
		}
		
		User userFound = userService.login(newLogin, result);
		
		if (userFound == null) {
			model.addAttribute("newUser", new User());
			return "index";
		}
		
		session.setAttribute("user", userFound);
		
		return "redirect:/home";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:/";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(HttpSession session) {
		
		if (session.getAttribute("user") == null) {
			return "redirect:/";
		}
		
		return "welcome";
	}
}
