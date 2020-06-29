package com.codegym.controller;

import com.codegym.model.City;
import com.codegym.model.Nation;
import com.codegym.service.ICityService;
import com.codegym.service.INationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @Autowired
    private ICityService cityService;

    @Autowired
    private INationService nationService;

    @ModelAttribute("nations")
    private Iterable<Nation> nations() {
        return nationService.findAll();
    }


    @GetMapping("/list")
    public ModelAndView showAll(@PageableDefault(value = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/list");
        Page<City> cities = cityService.findAll(pageable);
        modelAndView.addObject("cities", cities);
        return modelAndView;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView showDetail(@PathVariable Long id) {
        City city = cityService.findById(id);

        if (city != null) {
           ModelAndView modelAndView = new ModelAndView("detail");
           modelAndView.addObject(city);
           return modelAndView;
        }
        return new ModelAndView("error");
    }

    @GetMapping("/create")
    public ModelAndView createCity() {
        ModelAndView modelAndView = new ModelAndView("/create");
        City city = new City();
        modelAndView.addObject(city);
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView saveCity(@ModelAttribute City city) {
        ModelAndView modelAndView = new ModelAndView("/create");
        try {
            cityService.save(city);
        } catch (Exception e) {
            e.printStackTrace();
        }
        modelAndView.addObject("message", "Create new city successfully");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showFormDelete(@PathVariable Long id) {
        City city = cityService.findById(id);
        if (city != null) {
            ModelAndView modelAndView = new ModelAndView("delete");
            modelAndView.addObject(city);
            return modelAndView;
        }
        return new ModelAndView("error");
    }

    @PostMapping("/delete/{id}")
    public ModelAndView deleteCity(@PathVariable Long id) {
        cityService.remove(id);
        return new ModelAndView("list");
    }
}
