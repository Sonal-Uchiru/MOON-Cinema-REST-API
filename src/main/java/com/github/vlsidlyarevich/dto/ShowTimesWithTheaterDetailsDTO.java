package com.github.vlsidlyarevich.dto;

import com.github.vlsidlyarevich.model.ShowTime;
import com.github.vlsidlyarevich.model.Theater;

import java.util.List;

public class ShowTimesWithTheaterDetailsDTO {
    private List<ShowTime> showTimes;
    private Theater theater;

    public ShowTimesWithTheaterDetailsDTO() {
    }

    public List<ShowTime> getShowTimes() {
        return showTimes;
    }

    public void setShowTimes(List<ShowTime> showTimes) {
        this.showTimes = showTimes;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }
}
