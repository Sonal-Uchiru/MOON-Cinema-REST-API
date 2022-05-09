package com.github.vlsidlyarevich.service;

import com.github.vlsidlyarevich.model.Cart;
import com.github.vlsidlyarevich.model.User;
import com.github.vlsidlyarevich.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CartService {
    private final CartRepository repository;

    @Autowired
    public CartService(CartRepository repository) {
        this.repository = repository;
    }

    public Cart saveCart(Cart cart, User user){
        cart.setCustomer_id(user.getId());
        cart.setCreatedAt(String.valueOf(LocalDateTime.now()));
        return this.repository.save(cart);
    }


}
