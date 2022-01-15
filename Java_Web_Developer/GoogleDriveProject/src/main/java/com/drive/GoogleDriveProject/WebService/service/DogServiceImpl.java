package com.drive.GoogleDriveProject.WebService.service;

import com.drive.GoogleDriveProject.WebService.repository.DogRepository;
import com.drive.GoogleDriveProject.WebService.restAPI.Dog;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class DogServiceImpl implements  DogService{
    @Autowired
    DogRepository dogRepository;
    @Override
    public List<Dog> retriveDogs() {
        return (List<Dog>) dogRepository.findAll();
    }

    @Override
    public List<String> retriveDogBreed() {
        return (List<String>) dogRepository.findAllNames();
    }

    @Override
    public String retrieveDogBreedById(Long id) {
        Optional<String>optionalBreed=Optional.ofNullable(dogRepository.findBreedById(id));
        String breed=optionalBreed.orElseThrow(DogNotFoundException::new);
        return breed;
    }

    @Override
    public List<String> retriveDogNames() {
        return (List<String>) dogRepository.findAllNames();
    }
}
