package com.github.vlsidlyarevich.controller;

import com.github.vlsidlyarevich.model.Movie;
import com.github.vlsidlyarevich.service.MovieService;
import com.github.vlsidlyarevich.service.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/movies")
public class MovieController {

    TokenInterceptor tokenInterceptor;
    MovieService movieService;

    @Autowired
    public MovieController(TokenInterceptor tokenInterceptor,MovieService movieService) {
        this.tokenInterceptor = tokenInterceptor;
        this.movieService = movieService;
    }

    @PostMapping()
    public Movie createMovie(@RequestBody Movie movie){
        return this.movieService.save(movie);
    }

}

