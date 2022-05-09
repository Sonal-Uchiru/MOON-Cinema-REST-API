package com.github.vlsidlyarevich.controller;

import com.github.vlsidlyarevich.service.ReservationService;
import com.github.vlsidlyarevich.service.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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



}
