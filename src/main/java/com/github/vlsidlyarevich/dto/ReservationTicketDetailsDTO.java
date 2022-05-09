package com.github.vlsidlyarevich.dto;

import com.github.vlsidlyarevich.model.Cart;
import com.github.vlsidlyarevich.model.Reservation;

public class ReservationTicketDetailsDTO {
    private Reservation reservation;
    private ShowTimeWithMovieTheaterDetailsDTO showTimeWithMovieTheaterDetailsDto;

    public ReservationTicketDetailsDTO() {
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public ShowTimeWithMovieTheaterDetailsDTO getShowTimeWithMovieTheaterDetailsDto() {
        return showTimeWithMovieTheaterDetailsDto;
    }

    public void setShowTimeWithMovieTheaterDetailsDto(ShowTimeWithMovieTheaterDetailsDTO showTimeWithMovieTheaterDetailsDto) {
        this.showTimeWithMovieTheaterDetailsDto = showTimeWithMovieTheaterDetailsDto;
    }
}
