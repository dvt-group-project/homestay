package com.thinkpad.homestay.controllers;

import com.thinkpad.homestay.models.House;
import com.thinkpad.homestay.services.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private HouseService houseService;

    @ModelAttribute("list-address")
    public Iterable<String> listAddress() {
        return houseService.findDistinctByAddress();
    }

    @GetMapping("/")
    public ModelAndView home() {
        String userName = getUserName();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("userName", userName);
        modelAndView.addObject("addresses",listAddress());
        return modelAndView;
    }

    public String getUserName() {
        String userName;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

    @GetMapping("listHome")
    public ModelAndView listHome(Pageable pageable) {
        Page<House> houses = houseService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("listHouse");
        modelAndView.addObject("houses", houses);
        return modelAndView;
    }
}
