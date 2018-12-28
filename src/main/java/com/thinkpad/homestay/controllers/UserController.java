package com.thinkpad.homestay.controllers;

import com.thinkpad.homestay.models.User;
import com.thinkpad.homestay.services.impl.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


@Controller
public class UserController {
//    private String getPrincipal() {
//        String userName = null;
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//        if (principal instanceof UserDetails) {
//            userName = ((UserDetails) principal).getUsername();
//        } else {
//            userName = principal.toString();
//        }
//        return userName;
//    }


//    @GetMapping("admin/home")
//    public ModelAndView home() {
//        ModelAndView modelAndView = new ModelAndView("admin/index");
//        return modelAndView;
//    }
//
//    @Autowired
//    private UserService userService;
//    @GetMapping("/login")
//    public ModelAndView login() {
//        return new ModelAndView("login");
//    }
//
//    @GetMapping("/registration")
//    public ModelAndView registration() {
//        ModelAndView modelAndView = new ModelAndView("regis");
//        User user = new User();
//        modelAndView.addObject("user", user);
//        return modelAndView;
//    }
//
//    @PostMapping("/registration")
//    public ModelAndView creatNewUser(@ModelAttribute("user") User user) {
//        ModelAndView modelAndView = new ModelAndView("regis");
//        userService.saveUser(user);
//        modelAndView.addObject("message", "User has been registered successfully");
//        modelAndView.addObject("user", new User());
//        return modelAndView;
//    }

    @GetMapping("/hello")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @GetMapping("/admin/index")
    public String admin() {
        return "admin";
    }

    @GetMapping("/403")
    public String accessDenied() {
        return "403";
    }

    @RequestMapping("/login")
    public String getLogin(HttpServletRequest request) {
//        String referrer = request.getHeader("Referer");
//        request.getSession().setAttribute("url_prior_login", referrer);
        return "login/login";
    }

    @GetMapping("/registration")
    public ModelAndView registration() {
        ModelAndView modelAndView = new ModelAndView("login/registration");
        User user = new User();
        modelAndView.addObject("user", user);
        return modelAndView;
    }
    @Autowired
    private UserDetailServiceImpl userDetailService;
    @PostMapping("/registration")
    public ModelAndView creatNewUser(@ModelAttribute("user") User user) {
        ModelAndView modelAndView = new ModelAndView("login/registration");
        userDetailService.saveUser(user);
        modelAndView.addObject("message", "User has been registered successfully");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

}
