package com.example.jpabasics.load;

import com.example.jpabasics.model.*;
import com.example.jpabasics.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Component
public class LoadData implements CommandLineRunner {
    private final PetRepository petRepository;
    private final OwnerRepository ownerRepository;
    private final CityRepository cityRepository;
    private final PetTypeRepository petTypeRepository;
    private final ClinicRepository clinicRepository;

    public LoadData(PetRepository petRepository, OwnerRepository ownerRepository, CityRepository cityRepository, PetTypeRepository petTypeRepository, ClinicRepository clinicRepository) {
        this.petRepository = petRepository;
        this.ownerRepository = ownerRepository;
        this.cityRepository = cityRepository;
        this.petTypeRepository = petTypeRepository;
        this.clinicRepository = clinicRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType petType = new PetType();
        petType.setName("Köpek");
        petTypeRepository.save(petType);
        Pet p1=new Pet();
        p1.setName("çomar");
        p1.setBirtdate(LocalDateTime.now());
        p1.setPetType(petType);

        City burdur = new City();
        burdur.setName("Burdur");

        cityRepository.save(burdur);

        Clinic clinic=new Clinic();
        clinic.setName("Kardeşler Veteriner");


        Owner owner=new Owner();
        owner.setName("Seyda");
        owner.setLastName("Özdemir");
        Address address=new Address();
        address.setCity(burdur);
        address.setCityCode(CityCode.ANTALYA);
        address.setPhone("555");
        address.setStreet("bucak");
        address.setPhoneType(PhoneType.WORK);
        owner.setAddress(address);
        owner.setRating(Rating.PREMIUM);


        ownerRepository.save(owner);
        clinic.setOwners(Set.of(owner));
        clinicRepository.save(clinic);
        p1.setOwner(owner);
        petRepository.save(p1);

        List<Owner> owners=ownerRepository.findAll();
        List<Pet> pets = petRepository.findAll();
    }
}
