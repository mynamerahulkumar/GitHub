package com.drive.GoogleDriveProject.WebService.Web;

import com.drive.GoogleDriveProject.WebService.restAPI.Dog;
import com.drive.GoogleDriveProject.WebService.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DogController {
    private DogService dogService;

    @Autowired
    public  void setDogService(DogService dogService){
        this.dogService=dogService;
    }
    @GetMapping("/dogs")
    public ResponseEntity<List<Dog>> getAllDogs(){
        List<Dog> lists=dogService.retriveDogs();
        return new ResponseEntity<List<Dog>>(lists, HttpStatus.OK);
    }
    @GetMapping("/dogs/breed")
    public ResponseEntity<List<String>> getDogBreed(){
        List<String> lists=dogService.retriveDogBreed();
        return new ResponseEntity<List<String>>(lists, HttpStatus.OK);
    }
    @GetMapping("/{id}/breed")
    public ResponseEntity<String> getBreedByID(@PathVariable Long id){
        String  dog=dogService.retrieveDogBreedById(id);
        return new ResponseEntity<String>(dog, HttpStatus.OK);
    }
    @GetMapping("/dogs/name")
    public ResponseEntity<List<String>> getDogNames(){
        List<String> lists=dogService.retriveDogNames();
        return new ResponseEntity<List<String>>(lists, HttpStatus.OK);
    }

}
