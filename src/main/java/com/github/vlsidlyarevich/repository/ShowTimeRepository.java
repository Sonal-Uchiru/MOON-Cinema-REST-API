package com.github.vlsidlyarevich.repository;

import com.github.vlsidlyarevich.model.ShowTime;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowTimeRepository extends MongoRepository<ShowTime, String> {

}
