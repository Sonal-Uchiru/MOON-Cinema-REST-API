package com.github.vlsidlyarevich.repository;

import com.github.vlsidlyarevich.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {
}
