package com.genspark.SpringSecurity.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class MyController
{
	@GetMapping("/public")
	public String publicUser()
	{
		return "<HTML><H1>I am a Public user</H1></HTML>";
	}

	@GetMapping("/admin")
	public String adminUser()
	{
		return "<HTML><H1>I am an Admin user</H1></HTML>";
	}

	@GetMapping("/normal")
	public String normalUser()
	{
		return "<HTML><H1>I am a Normal user</H1></HTML>";
	}
}
