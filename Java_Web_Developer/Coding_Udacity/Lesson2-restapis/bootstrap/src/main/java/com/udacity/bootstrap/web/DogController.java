package com.udacity.bootstrap.web;

import com.udacity.bootstrap.entity.Dog;
import com.udacity.bootstrap.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class DogController {
    private DogService dogService;
    @Autowired
    public void setDogService(DogService dogService){
        this.dogService=dogService;
    }
    @GetMapping("/dog")
    public ResponseEntity<List<Dog>> getAllDogs()
    {
        List<Dog> list=dogService.retrieveDogs();
        return new ResponseEntity<List<Dog>>(list,HttpStatus.OK);
    }
    @GetMapping("/dog/breed")
    public ResponseEntity<List<String>> getallDogBreed(){
        List<String>list=dogService.retrieveDogBreed();
        return  new ResponseEntity<List<String>>(list,HttpStatus.OK);
    }
    @GetMapping("{id}/dog")
    public ResponseEntity<String> getDogBreedById(@PathVariable Long id){
        String dog=dogService.retrieveDogBreedById(id);
        return new ResponseEntity<String>(dog,HttpStatus.OK);
    }
    @GetMapping("/dog/names")
    public ResponseEntity<List<String>> getdogByNames(){
        List<String>list=dogService.retrieveDogNames();
        return new ResponseEntity<List<String>>(list,HttpStatus.OK);
    }

}
