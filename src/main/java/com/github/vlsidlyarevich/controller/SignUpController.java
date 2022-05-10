package com.github.vlsidlyarevich.controller;

import com.github.vlsidlyarevich.converter.ConverterFacade;
import com.github.vlsidlyarevich.dto.UserDTO;
import com.github.vlsidlyarevich.model.User;
import com.github.vlsidlyarevich.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/signup")
public class SignUpController {

    private final UserService service;


    @Autowired
    public SignUpController(final UserService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> signUp(@RequestBody final User userBody) throws Exception {
            User user = service.create(userBody);
            return new ResponseEntity<>(user, HttpStatus.OK);




    }
}
