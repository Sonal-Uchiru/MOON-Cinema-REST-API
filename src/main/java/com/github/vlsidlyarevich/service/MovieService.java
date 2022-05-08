package com.github.vlsidlyarevich.service;

import com.github.vlsidlyarevich.model.Movie;
import com.github.vlsidlyarevich.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
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

    public Movie getMovie(String movieId) throws Exception {
        Movie movie = this.repository.findOne(movieId);
        if(movie != null){
            return this.repository.findOne(movieId);
        }else{
            throw new Exception("Movie Not found");
        }

    }

    public void updateMovie(String movieId,Movie movie) throws Exception {
        Movie movieDB = getMovie(movieId);
        if(movieDB != null) {
            movieDB.setUpdatedAt(String.valueOf(LocalDateTime.now()));
            movieDB.setName(movie.getName());
            movieDB.setImage(movie.getImage());
            movieDB.setDuration(movie.getDuration());
            movieDB.setGenre(movie.getGenre());
            movieDB.setStory_line(movie.getStory_line());
            movieDB.setLanguage(movie.getLanguage());
            movieDB.setImdb_key(movie.getImdb_key());
            movie.setShowing(movie.getShowing());
            this.repository.save(movieDB);
        }else{
            throw new Exception("Movie Not Found");
        }

    }


    public void deleteMovie(String movieId) throws Exception {
        this.getMovie(movieId);
        this.repository.delete(movieId);
    }
}
