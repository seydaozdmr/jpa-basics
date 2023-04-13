package com.example.jpabasics.repository;

import com.example.jpabasics.model.PetType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetTypeRepository extends JpaRepository<PetType,Long> {
}
