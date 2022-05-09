package com.github.vlsidlyarevich.dto;

import com.github.vlsidlyarevich.model.Movie;
import com.github.vlsidlyarevich.model.ShowTime;
import com.github.vlsidlyarevich.model.Theater;

public class ShowTimeWithMovieTheaterDetailsDTO {
    private ShowTime showTime;
    private Movie movie;
    private Theater theater;

    public ShowTimeWithMovieTheaterDetailsDTO() {
    }

    public ShowTime getShowTime() {
        return showTime;
    }

    public void setShowTime(ShowTime showTime) {
        this.showTime = showTime;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }
}
