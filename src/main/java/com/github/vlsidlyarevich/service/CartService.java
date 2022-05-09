package com.github.vlsidlyarevich.service;

import com.github.vlsidlyarevich.repository.CartRepository;
import com.github.vlsidlyarevich.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    private final CartRepository repository;

    @Autowired
    public CartService(CartRepository repository) {
        this.repository = repository;
    }

}
