package com.github.vlsidlyarevich.repository;

import com.github.vlsidlyarevich.model.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends MongoRepository<Cart, String> {
}
