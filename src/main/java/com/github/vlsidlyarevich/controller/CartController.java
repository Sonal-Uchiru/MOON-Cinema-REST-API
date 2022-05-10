package com.github.vlsidlyarevich.controller;

import com.github.vlsidlyarevich.dto.CartTicketDetailsDTO;
import com.github.vlsidlyarevich.model.Cart;
import com.github.vlsidlyarevich.model.User;
import com.github.vlsidlyarevich.service.CartService;
import com.github.vlsidlyarevich.service.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
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

    @GetMapping()
    public List<CartTicketDetailsDTO> getCart(@RequestHeader(name = "x-auth-token") String jwtToken) throws Exception {
        User user = this.tokenInterceptor.getUserByToken(jwtToken);
        return this.cartService.getUserCart(user);
    }

    @DeleteMapping("/{id}")
    public void removeCartTicket(@PathVariable String id) throws Exception {
        this.cartService.removeCartTicket(id);
    }

    @PatchMapping("{id}/ticket")
    public void updateCartTicket(@PathVariable String id, @Param("isChild") boolean isChild,@Param("tickets") int tickets) throws Exception {
       this.cartService.updateTicketCount(id,isChild,tickets);
    }

}
