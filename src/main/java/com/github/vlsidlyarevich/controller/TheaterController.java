package com.github.vlsidlyarevich.controller;

import com.github.vlsidlyarevich.model.Theater;
import com.github.vlsidlyarevich.service.TheaterService;
import com.github.vlsidlyarevich.service.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/api/theaters")
public class TheaterController {
    TokenInterceptor tokenInterceptor;
    TheaterService theaterService;

    @Autowired
    public TheaterController(TokenInterceptor tokenInterceptor,TheaterService theaterService) {
        this.tokenInterceptor = tokenInterceptor;
        this.theaterService = theaterService;
    }

    @GetMapping()
    public List<Theater> getTheaters() {
        return this.theaterService.getTheaters();
    }

    @GetMapping("/{id}")
    public Theater getTheater(@PathVariable String id) throws Exception {
        return this.theaterService.getTheater(id);
    }

}
