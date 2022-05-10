package com.github.vlsidlyarevich.controller;

import com.github.vlsidlyarevich.model.Theater;
import com.github.vlsidlyarevich.service.TheaterService;
import com.github.vlsidlyarevich.service.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
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
