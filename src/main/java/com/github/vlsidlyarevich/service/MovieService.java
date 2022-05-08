package com.github.vlsidlyarevich.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    private final MovieService repository;

    @Autowired
    public MovieService(MovieService repository) {
        this.repository = repository;
    }


}
