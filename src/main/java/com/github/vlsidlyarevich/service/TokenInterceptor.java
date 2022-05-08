package com.github.vlsidlyarevich.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.vlsidlyarevich.model.User;
import com.github.vlsidlyarevich.security.service.JsonWebTokenAuthenticationService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

@Service
public class TokenInterceptor{
	private JsonWebTokenAuthenticationService jsonWebTokenAuthenticationService;
	  @Autowired
	public TokenInterceptor(JsonWebTokenAuthenticationService jsonWebTokenAuthenticationService) {
		this.jsonWebTokenAuthenticationService = jsonWebTokenAuthenticationService;
	} 
	
	public User getUserByToken(String jwtToken) {
	  	Jws<Claims> token = this.jsonWebTokenAuthenticationService.parseToken(jwtToken);
    	return this.jsonWebTokenAuthenticationService.getUserFromToken(token);
	}
}