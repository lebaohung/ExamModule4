package com.codegym.repository;

import com.codegym.model.Nation;
import org.springframework.data.repository.CrudRepository;

public interface NationRepository extends CrudRepository<Nation, Integer> {
}
