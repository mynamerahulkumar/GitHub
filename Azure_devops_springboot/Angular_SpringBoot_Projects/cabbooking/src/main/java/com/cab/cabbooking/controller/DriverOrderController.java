package com.cab.cabbooking.controller;

import com.cab.cabbooking.dtos.Driver;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/driver")
public class DriverOrderController {


    @PostMapping("/register")
    public ResponseEntity<Driver> register(@RequestBody Driver driver){
        return null;
    }

    @PutMapping("/update")
    public ResponseEntity<Driver> update(@RequestBody Driver driver,
                                         @RequestParam("uuid") String uuid){
        return null;
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Driver> delete(@RequestParam("driverId") Integer driverId,
                                         @RequestParam("uuid")String uuid
                                         ){
        return null;
    }


}
