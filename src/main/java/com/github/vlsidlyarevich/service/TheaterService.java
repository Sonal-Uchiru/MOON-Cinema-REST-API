package com.github.vlsidlyarevich.service;


import com.github.vlsidlyarevich.model.Theater;
import com.github.vlsidlyarevich.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheaterService {
    private final TheaterRepository repository;

    @Autowired
    public TheaterService(TheaterRepository repository) {
        this.repository = repository;
    }

    public List<Theater> getTheaters(){
        return repository.findAll();
    }

    public Theater getTheater(String theaterId) throws Exception {
        Theater theater = this.repository.findOne(theaterId);
        if(theater != null){
            return theater;
        }else{
            throw new Exception("Theater Not Found");
        }
    }

}
