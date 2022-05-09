package com.github.vlsidlyarevich.service;

import com.github.vlsidlyarevich.dto.ShowTimeWithMovieDetailsDTO;
import com.github.vlsidlyarevich.dto.ShowTimeWithMovieTheaterDetailsDTO;
import com.github.vlsidlyarevich.model.ShowTime;
import com.github.vlsidlyarevich.model.User;
import com.github.vlsidlyarevich.repository.ShowTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShowTimeService {
    private final ShowTimeRepository repository;
    private final MovieService movieService;
    private final TheaterService theaterService;
    @Autowired
    public ShowTimeService(ShowTimeRepository showTimeRepository,MovieService movieService,TheaterService theaterService) {
        this.repository = showTimeRepository;
        this.movieService = movieService;
        this.theaterService = theaterService;
    }

    public ShowTime saveShowTime(ShowTime showTime, User user) {
        showTime.setModified_user(user.getId());
        showTime.setCreatedAt(String.valueOf(LocalDateTime.now()));
        showTime.setStatus(1);
        return this.repository.save(showTime);
    }

    public void removeShowTime(String showTimeId) throws Exception {
        this.getShowTimeById(showTimeId);
        this.repository.delete(showTimeId);
    }

    public void updateShowTime(String showTimeId,ShowTime showTime,User user) throws Exception {
        ShowTime showTimeDB = this.getShowTimeById(showTimeId);
        showTimeDB.setTheater_id(showTime.getTheater_id());
        showTimeDB.setShow_time(showTime.getShow_time());
        showTimeDB.setMovie_id(showTime.getMovie_id());
        showTime.setUpdatedAt(String.valueOf(LocalDateTime.now()));
        showTime.setModified_user(user.getId());
        this.repository.save(showTimeDB);
    }

    public void updateShowTimeStatus(String showTimeId, User user) throws Exception {
        ShowTime showTime = this.getShowTimeById(showTimeId);
        if(showTime.getStatus() == 1){
            showTime.setStatus(0);
        }else{
            showTime.setStatus(1);
        }
        showTime.setModified_user(user.getId());
        showTime.setUpdatedAt(String.valueOf(LocalDateTime.now()));
        this.repository.save(showTime);
    }



    public ShowTime getShowTimeById(String ShowTimeId) throws Exception {
        ShowTime showTime = this.repository.findOne(ShowTimeId);
        if(showTime != null){
            return showTime;
        }else{
            throw new Exception("Show Time Not Found");
        }
    }

    public List<ShowTimeWithMovieDetailsDTO> getShowTimesWithMoviesByTheaterId(String theaterId) throws Exception {
        List<ShowTime> ShowTimes = this.repository.findAll();
        List<ShowTimeWithMovieDetailsDTO> showTimeWithMovieDetails = new ArrayList<>();
        if(ShowTimes.size() > 0){
            for(ShowTime value : ShowTimes){
                if(value.getTheater_id().equals(theaterId)){
                    ShowTimeWithMovieDetailsDTO newShowTimeWithMovieDetails = new ShowTimeWithMovieDetailsDTO();
                    newShowTimeWithMovieDetails.setShowTime(value);
                    newShowTimeWithMovieDetails.setMovie(this.movieService.getMovie(value.getMovie_id()));
                    showTimeWithMovieDetails.add(newShowTimeWithMovieDetails);
                }

            }
        }

        return showTimeWithMovieDetails;
    }

    public ShowTimeWithMovieTheaterDetailsDTO getShowTimesWithMoviesAndTheaterDetailsById(String showTimeId) throws Exception {
        ShowTime showTime = this.getShowTimeById(showTimeId);
        ShowTimeWithMovieTheaterDetailsDTO showTimeWithMovieTheaterDetailsDTO = new ShowTimeWithMovieTheaterDetailsDTO();
        showTimeWithMovieTheaterDetailsDTO.setShowTime(showTime);
        showTimeWithMovieTheaterDetailsDTO.setMovie(this.movieService.getMovie(showTime.getMovie_id()));
        showTimeWithMovieTheaterDetailsDTO.setTheater(this.theaterService.getTheater(showTime.getTheater_id()));
        return showTimeWithMovieTheaterDetailsDTO;
    }

}
