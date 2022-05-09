package com.github.vlsidlyarevich.service;

import com.github.vlsidlyarevich.model.Reservation;
import com.github.vlsidlyarevich.model.User;
import com.github.vlsidlyarevich.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ReservationService {
    private final ReservationRepository repository;

    @Autowired
    public ReservationService(ReservationRepository repository) {
        this.repository = repository;
    }

    public Reservation saveReservation(Reservation reservation, User user){
        reservation.setCustomer_id(user.getId());
        reservation.setCreatedAt(String.valueOf(LocalDateTime.now()));
        reservation.setStatus(0);
        return this.repository.save(reservation);
    }
}
