package com.github.vlsidlyarevich.controller;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.github.vlsidlyarevich.model.User;
import com.github.vlsidlyarevich.model.UserAuthentication;
import com.github.vlsidlyarevich.security.service.JsonWebTokenAuthenticationService;
import com.github.vlsidlyarevich.service.TokenInterceptor;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/hello")
public class SecuredController {
	
	TokenInterceptor tokenInterceptor;
	@Autowired
	public SecuredController(TokenInterceptor tokenInterceptor) {
		this.tokenInterceptor = tokenInterceptor;
	}
	
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> sayHello(@RequestHeader (name = "x-auth-token") String jwtToken ) {
    	User user = this.tokenInterceptor.getUserByToken(jwtToken);
        return new ResponseEntity<>("Secured hello!ss--"+ user.getId(), HttpStatus.OK);
    }
    
}
