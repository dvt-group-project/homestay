package com.thinkpad.homestay.controllers;

import com.thinkpad.homestay.models.House;
import com.thinkpad.homestay.models.Reservation;
import com.thinkpad.homestay.services.HouseService;
import com.thinkpad.homestay.services.ReservationService;
import com.thinkpad.homestay.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReservationController {
    @Autowired
    private UserService userService;

    @Autowired
    private HouseService houseService;

    @Autowired
    private ReservationService reservationService;

    @ModelAttribute("houses")
    private Iterable<House> houses() {
        return houseService.findAll();
    }

    @PostMapping("/booknow")
    public ModelAndView bookAHomestay(@ModelAttribute("reservation") Reservation reservation) {
        reservation.setStatus("leasing");
        reservationService.save(reservation);
        ModelAndView modelAndView = new ModelAndView("redirect:/houses", "reservation", reservation);
        return modelAndView;
    }

    @GetMapping("/reservations")
    public ModelAndView reservations() {
        Iterable<Reservation> reservations = reservationService.findAll();
        return new ModelAndView("reservation/list", "reservations", reservations);
    }

    @GetMapping("/reservation-detail/{id}")
    public ModelAndView reservationDetail(@PathVariable("id") Integer id) {
        return new ModelAndView("reservation/detail", "reservation", reservationService.findById(id));
    }
}
