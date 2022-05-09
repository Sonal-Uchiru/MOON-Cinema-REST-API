package com.github.vlsidlyarevich.dto;

import com.github.vlsidlyarevich.model.Movie;
import com.github.vlsidlyarevich.model.ShowTime;

public class ShowTimeWithMovieDetailsDTO {
    private ShowTime showTime;
    private Movie move;

    public ShowTimeWithMovieDetailsDTO() {
    }

    public ShowTime getShowTime() {
        return showTime;
    }

    public void setShowTime(ShowTime showTime) {
        this.showTime = showTime;
    }

    public Movie getMovie() {
        return move;
    }

    public void setMovie(Movie move) {
        this.move = move;
    }
}
