package com.thinkpad.homestay.services;

import com.thinkpad.homestay.models.Reservation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ReservationService {
    Page<Reservation> findAll(Pageable pageable);

    Optional<Reservation> findById(Integer id);

    void save(Reservation reservation);

    void delete(Integer id);

    Iterable<Reservation> findAll();

}
