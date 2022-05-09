package com.github.vlsidlyarevich.controller;

import com.github.vlsidlyarevich.model.Cart;
import com.github.vlsidlyarevich.model.User;
import com.github.vlsidlyarevich.service.CartService;
import com.github.vlsidlyarevich.service.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/carts")
public class CartController {
    TokenInterceptor tokenInterceptor;
    CartService cartService;

    @Autowired
    public CartController(TokenInterceptor tokenInterceptor, CartService cartService) {
        this.tokenInterceptor = tokenInterceptor;
        this.cartService = cartService;
    }

    @PostMapping()
    public Cart createCart(@RequestBody Cart cart,@RequestHeader(name = "x-auth-token") String jwtToken ){
        User user = this.tokenInterceptor.getUserByToken(jwtToken);
        return this.cartService.saveCart(cart,user);
    }

}
