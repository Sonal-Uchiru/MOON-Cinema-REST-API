package com.github.vlsidlyarevich.controller;

import com.github.vlsidlyarevich.model.Reservation;
import com.github.vlsidlyarevich.model.User;
import com.github.vlsidlyarevich.service.ReservationService;
import com.github.vlsidlyarevich.service.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/reservations")
public class ReservationController {

    TokenInterceptor tokenInterceptor;
    ReservationService reservationService;

    @Autowired
    public ReservationController(TokenInterceptor tokenInterceptor, ReservationService reservationService) {
        this.tokenInterceptor = tokenInterceptor;
        this.reservationService = reservationService;
    }

    @PostMapping()
    public Reservation createReservation(@RequestBody Reservation reservation, @RequestHeader (name = "x-auth-token") String jwtToken ){
        User user = this.tokenInterceptor.getUserByToken(jwtToken);
        return this.reservationService.saveReservation(reservation,user);
    }



}
