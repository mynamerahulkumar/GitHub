package com.cab.cabbooking.controller;

import com.cab.cabbooking.dtos.CabOutPutDTO;
import com.cab.cabbooking.dtos.DriverOutPutDTO;
import com.cab.cabbooking.entity.Driver;
import com.cab.cabbooking.services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/driver")
public class DriverOrderController {

    @Autowired
    private DriverService driverService;


    @PostMapping("/register")
    public ResponseEntity<DriverOutPutDTO> register(@RequestBody Driver driver){
        DriverOutPutDTO response=driverService.insertDriver(driver);
        String s=null;
       String s2= s.substring(1);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<DriverOutPutDTO> update(@RequestBody Driver driver,
                                         @RequestParam("uuid") String uuid){
        DriverOutPutDTO response=driverService.updateDriver(driver,uuid);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<DriverOutPutDTO> delete(@RequestParam("driverId") Integer driverId,
                                         @RequestParam("uuid")String uuid
                                         ){
        DriverOutPutDTO response=driverService.deleteDriver(driverId,uuid);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


}
