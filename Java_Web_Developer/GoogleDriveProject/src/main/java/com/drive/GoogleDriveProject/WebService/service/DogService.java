package com.drive.GoogleDriveProject.WebService.service;

import com.drive.GoogleDriveProject.WebService.restAPI.Dog;

import java.util.List;

public interface DogService {
    List<Dog>retriveDogs();
    List<String> retriveDogBreed();
    String retrieveDogBreedById(Long id);
    List<String>retriveDogNames();
}
