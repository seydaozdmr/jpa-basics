package com.example.jpabasics.load;

import com.example.jpabasics.model.Pet;
import com.example.jpabasics.repository.PetRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Component
public class LoadData implements CommandLineRunner {
    private final PetRepository petRepository;

    public LoadData(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Pet p1=new Pet();
        p1.setName("çomar");
        p1.setBirtdate(LocalDateTime.now());
        p1.setPetType("köpek");
        petRepository.save(p1);
    }
}
