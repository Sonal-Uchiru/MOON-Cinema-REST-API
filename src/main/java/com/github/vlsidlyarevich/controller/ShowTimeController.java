package com.github.vlsidlyarevich.controller;

import com.github.vlsidlyarevich.service.CartService;
import com.github.vlsidlyarevich.service.ShowTimeService;
import com.github.vlsidlyarevich.service.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
