package com.codegym.service;

import com.codegym.model.Nation;

public interface INationService {
    public Iterable<Nation> findAll();
    public Nation findById(Integer id);
}
