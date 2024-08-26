package com.MO.Software.Login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MO.Software.Login.service.loginServiceInterface;

@RestController
@RequestMapping("/login")
@Service
public class loginRestController {

	@Autowired
	private loginServiceInterface loginServiceI;
	
	public Long loginEndPoint(String username,String password) {
		return loginServiceI.checkLogin(username, password);
	}
}
