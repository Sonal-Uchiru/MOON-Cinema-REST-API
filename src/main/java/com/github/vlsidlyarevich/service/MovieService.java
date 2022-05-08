package com.github.vlsidlyarevich.service;

import com.github.vlsidlyarevich.model.Movie;
import com.github.vlsidlyarevich.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MovieService {
    private final MovieRepository repository;

    @Autowired
    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }

    public Movie save(Movie movie) {
            movie.setCreatedAt(String.valueOf(LocalDateTime.now()));
            return this.repository.save(movie);
    }

    public List<Movie> getMovies(){
        return  this.repository.findAll();
    }
}
