package com.example.jpabasics.repository;

import com.example.jpabasics.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet,Long> {
}
