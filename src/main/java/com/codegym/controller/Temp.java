package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Temp {

    @GetMapping("/temp")
    public ModelAndView showTemp() {
        return new ModelAndView("tempview");
    }
}
