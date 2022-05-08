package com.github.vlsidlyarevich.repository;

import com.github.vlsidlyarevich.model.Theater;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterRepository extends MongoRepository<Theater, String> {
}
