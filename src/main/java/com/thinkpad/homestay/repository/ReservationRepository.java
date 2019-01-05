package com.thinkpad.homestay.repository;

import com.thinkpad.homestay.models.Reservation;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ReservationRepository extends PagingAndSortingRepository<Reservation, Integer> {
}
