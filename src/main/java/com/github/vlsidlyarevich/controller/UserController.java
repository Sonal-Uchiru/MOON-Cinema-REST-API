package com.github.vlsidlyarevich.controller;

import com.github.vlsidlyarevich.dto.ChangePasswordDTO;
import com.github.vlsidlyarevich.model.User;
import com.github.vlsidlyarevich.service.TokenInterceptor;
import com.github.vlsidlyarevich.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/users")
public class UserController {
    TokenInterceptor tokenInterceptor;
    UserService userService;
    @Autowired
    public UserController(TokenInterceptor tokenInterceptor,UserService userService) {
        this.tokenInterceptor = tokenInterceptor;
        this.userService = userService;
    }

    // Not a protected route
    @PatchMapping("/{email}/password")
    public void changePassword(@RequestBody ChangePasswordDTO changePasswordDTO, @PathVariable String email) throws Exception {
            this.userService.updatePassword(email,changePasswordDTO.getPassword());

    }

    @GetMapping()
    public User getUser(@RequestHeader (name = "x-auth-token") String jwtToken ) throws Exception {
        return this.tokenInterceptor.getUserByToken(jwtToken);
    }
}
