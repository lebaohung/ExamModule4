package com.codegym.service;

import com.codegym.model.Nation;
import com.codegym.repository.NationRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class NationService implements INationService {

    @Autowired
    private NationRepository nationRepository;

    @Override
    public Iterable<Nation> findAll() {
        return nationRepository.findAll();
    }

    @Override
    public Nation findById(Integer id) {
        return nationRepository.findOne(id);
    }
}
