package com.github.vlsidlyarevich.service;

import com.github.vlsidlyarevich.dto.ReservationTicketDetailsDTO;
import com.github.vlsidlyarevich.model.Reservation;
import com.github.vlsidlyarevich.model.User;
import com.github.vlsidlyarevich.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class ReservationService {
    private final ReservationRepository repository;
    private final ShowTimeService showTimeService;

    @Autowired
    public ReservationService(ReservationRepository repository,ShowTimeService showTimeService) {
        this.repository = repository;
        this.showTimeService = showTimeService;
    }

    public Reservation saveReservation(Reservation reservation, User user){
        reservation.setCustomer_id(user.getId());
        reservation.setCreatedAt(String.valueOf(LocalDateTime.now()));
        reservation.setStatus(0);
        return this.repository.save(reservation);
    }

    public void updateReservationStatus(String reservationId) throws Exception {
        Reservation reservation = this.getReservationById(reservationId);
        reservation.setStatus(1);
        reservation.setUpdatedAt(String.valueOf(LocalDateTime.now()));
        this.repository.save(reservation);
    }

    public Reservation getReservationById(String reservationId) throws Exception {
        Reservation reservation = this.repository.findOne(reservationId);
        if(reservation != null){
            return reservation;
        }else{
            throw new Exception("Reservation Not Found");
        }
    }

    public List<ReservationTicketDetailsDTO> getReservations(User user) throws Exception {
        List<Reservation> reservation = this.repository.findAll();
        List<ReservationTicketDetailsDTO> userReservations = new ArrayList<>();
        for (Reservation value : reservation) {
            if (value.getCustomer_id().equals(user.getId())  && value.getStatus() == 0) {
                ReservationTicketDetailsDTO userReservation = new ReservationTicketDetailsDTO();
                userReservation.setReservation(value);
                userReservation.setShowTimeWithMovieTheaterDetailsDto(this.showTimeService.getShowTimesWithMoviesAndTheaterDetailsById(value.getShow_time_id()));
                userReservations.add(userReservation);
            }
        }

        return userReservations;
    }
}
