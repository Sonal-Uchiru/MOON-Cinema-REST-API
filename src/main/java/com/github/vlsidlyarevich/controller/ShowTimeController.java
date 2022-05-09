package com.github.vlsidlyarevich.controller;

import com.github.vlsidlyarevich.dto.ShowTimeWithMovieDetailsDTO;
import com.github.vlsidlyarevich.model.ShowTime;
import com.github.vlsidlyarevich.model.User;
import com.github.vlsidlyarevich.service.ShowTimeService;
import com.github.vlsidlyarevich.service.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/showtimes")
public class ShowTimeController {
    TokenInterceptor tokenInterceptor;
    ShowTimeService showTimeService;

    @Autowired
    public ShowTimeController(TokenInterceptor tokenInterceptor, ShowTimeService showTimeService) {
        this.tokenInterceptor = tokenInterceptor;
        this.showTimeService = showTimeService;
    }

    @PostMapping()
    public ShowTime addShowTime(@RequestBody ShowTime showTime,@RequestHeader(name = "x-auth-token") String jwtToken ) {
        User user = this.tokenInterceptor.getUserByToken(jwtToken);
        return this.showTimeService.saveShowTime(showTime,user);
    }

    @PutMapping("/{id}")
    public void updateShowTime(@RequestBody ShowTime showTime,@RequestHeader (name = "x-auth-token") String jwtToken,@PathVariable String id) throws Exception {
        User user = this.tokenInterceptor.getUserByToken(jwtToken);
        this.showTimeService.updateShowTime(id,showTime,user);
    }

    @GetMapping("theaters/{id}")
    public List<ShowTimeWithMovieDetailsDTO> getShowTimesWithMovies(@PathVariable String id) throws Exception {
        return this.showTimeService.getShowTimesWithMovies(id);
    }

    @PatchMapping("{id}/status")
    public void updateShowTimeStatus(@PathVariable String id,@RequestHeader (name = "x-auth-token") String jwtToken ) throws Exception {
        User user = this.tokenInterceptor.getUserByToken(jwtToken);
        this.showTimeService.updateShowTimeStatus(id,user);
    }

    @DeleteMapping("/{id}")
    public void deleteShowTIme(@PathVariable String id) throws Exception {
        this.showTimeService.removeShowTime(id);
    }

}
