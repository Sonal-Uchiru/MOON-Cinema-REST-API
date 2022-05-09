package com.github.vlsidlyarevich.service;

import com.github.vlsidlyarevich.repository.ShowTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowTimeService {
    private final ShowTimeRepository repository;

    @Autowired
    public ShowTimeService(ShowTimeRepository showTimeRepository) {
        this.repository = showTimeRepository;
    }


}
