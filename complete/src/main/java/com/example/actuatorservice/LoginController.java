package com.example.actuatorservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;

	@PostMapping("/login")
	@ResponseBody
	public boolean login(
			@RequestParam(name="username", required=true) String username,
			@RequestParam(name="password", required=true) String password) throws Exception {
		
		return loginService.login(new LoginCredentials(username, password));
	}

}
