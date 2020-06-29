package com.codegym.service;

import com.codegym.model.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICityService {
    Page<City>  findAll(Pageable pageable);
    City findById(Long id);
    void save(City city) throws Exception;
    void remove(Long id);
}
