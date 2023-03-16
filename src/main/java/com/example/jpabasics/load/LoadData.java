package com.example.jpabasics.load;

import com.example.jpabasics.model.*;
import com.example.jpabasics.repository.OwnerRepository;
import com.example.jpabasics.repository.PetRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class LoadData implements CommandLineRunner {
    private final PetRepository petRepository;
    private final OwnerRepository ownerRepository;

    public LoadData(PetRepository petRepository, OwnerRepository ownerRepository) {
        this.petRepository = petRepository;
        this.ownerRepository = ownerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Pet p1=new Pet();
        p1.setName("çomar");
        p1.setBirtdate(LocalDateTime.now());
        p1.setPetType("köpek");
        petRepository.save(p1);

        Owner owner=new Owner();
        owner.setName("Seyda");
        owner.setLastName("Özdemir");
        Address address=new Address();
        address.setPhone("555");
        address.setStreet("bucak");
        address.setPhoneType(PhoneType.WORK);
        owner.setAddress(address);
        owner.setRating(Rating.PREMIUM);
        ownerRepository.save(owner);
    }
}
