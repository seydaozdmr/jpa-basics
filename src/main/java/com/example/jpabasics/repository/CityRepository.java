package com.example.jpabasics.repository;

import com.example.jpabasics.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City,Long> {
}
