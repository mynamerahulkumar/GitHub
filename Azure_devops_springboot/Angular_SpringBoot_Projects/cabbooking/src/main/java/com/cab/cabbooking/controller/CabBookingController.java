package com.cab.cabbooking.controller;

import com.cab.cabbooking.entity.Cab;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cab")
public class CabBookingController {


    @PostMapping("/register")
    public ResponseEntity<Cab> register(@RequestBody Cab cab){
        return null;
    }

    @PutMapping("/update")
    public ResponseEntity<Cab> update(@RequestBody Cab cab,
                                      @RequestParam("cuid") String cabUserId){
        return null;
    }

    public ResponseEntity<Cab> deleteCab(@RequestParam("cabId") String cabId,
                                         @RequestParam("cuid")String cabUserId){
        return null;
    }



}
