package com.github.vlsidlyarevich.controller;

import com.github.vlsidlyarevich.model.Movie;
import com.github.vlsidlyarevich.service.MovieService;
import com.github.vlsidlyarevich.service.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
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

    @GetMapping()
    public List<Movie> getMovies(){
        return this.movieService.getMovies();
    }

    @GetMapping("/{id}")
    public Movie getMovie(@PathVariable String id) throws Exception {
        return this.movieService.getMovie(id);
    }

    @PutMapping("/{id}")
    public void updateMovie(@PathVariable String id,@RequestBody Movie movie) throws Exception {
        this.movieService.updateMovie(id,movie);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable String id) throws Exception {
        this.movieService.deleteMovie(id);
    }

}

