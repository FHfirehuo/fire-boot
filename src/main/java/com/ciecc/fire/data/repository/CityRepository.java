package com.ciecc.fire.data.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ciecc.fire.domain.City;

public interface CityRepository extends JpaRepository<City, Long> {

	Page<City> findAll(Pageable pageable);

    City findByNameAndCountryAllIgnoringCase(String name, String country);
}
