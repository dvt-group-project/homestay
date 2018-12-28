package com.thinkpad.homestay.services.impl;

import com.thinkpad.homestay.models.Reservation;
import com.thinkpad.homestay.repository.ReservationRepository;
import com.thinkpad.homestay.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public Page<Reservation> findAll(Pageable pageable) {
        return reservationRepository.findAll(pageable);
    }

    @Override
    public Optional<Reservation> findById(Integer id) {
        return reservationRepository.findById(id);
    }

    @Override
    public void save(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    @Override
    public void delete(Integer id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public Iterable<Reservation> findAll() {
        return reservationRepository.findAll();
    }
}
