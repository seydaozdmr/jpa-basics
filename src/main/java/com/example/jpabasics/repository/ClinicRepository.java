package com.example.jpabasics.repository;

import com.example.jpabasics.model.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClinicRepository extends JpaRepository<Clinic,Long> {
}
