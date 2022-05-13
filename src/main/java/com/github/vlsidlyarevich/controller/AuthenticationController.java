package com.github.vlsidlyarevich.controller;

import com.github.vlsidlyarevich.dto.LoginDTO;
import com.github.vlsidlyarevich.dto.TokenDTO;
import com.github.vlsidlyarevich.dto.TokenWithRole;
import com.github.vlsidlyarevich.model.User;
import com.github.vlsidlyarevich.security.service.BasicUserDetailsService;
import com.github.vlsidlyarevich.security.service.TokenService;
import com.github.vlsidlyarevich.service.BasicUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private final TokenService tokenService;
    private final BasicUserService basicUserService;

    @Autowired
    public AuthenticationController(final TokenService tokenService,BasicUserService basicUserService) {
        this.tokenService = tokenService;
        this.basicUserService = basicUserService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> authenticate(@RequestBody final LoginDTO dto) {
        final String token = tokenService.getToken(dto.getUsername(), dto.getPassword());
        
        if (token != null) {
            final TokenWithRole response = new TokenWithRole();
            User user = this.basicUserService.findByUsername(dto.getUsername());
            response.setToken(token);
            response.setUserRole(user.getRole());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid Credentials!", HttpStatus.OK);
        }
    }
}

