package com.github.vlsidlyarevich.controller;

import com.github.vlsidlyarevich.service.CartService;
import com.github.vlsidlyarevich.service.ReservationService;
import com.github.vlsidlyarevich.service.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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



}
