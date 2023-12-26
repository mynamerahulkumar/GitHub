package com.cab.cabbooking.controller;

import com.cab.cabbooking.dtos.CabOutPutDTO;
import com.cab.cabbooking.entity.Cab;
import com.cab.cabbooking.services.CabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cab")
public class CabBookingController {

    @Autowired
    private CabService cabService;



    @PostMapping("/register")
    public ResponseEntity<CabOutPutDTO> register(@RequestBody Cab cab){
        CabOutPutDTO response=cabService.insertCab(cab);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<CabOutPutDTO> update(@RequestBody Cab cab,
                                      @RequestParam("uuid") String uuid){
        CabOutPutDTO response=cabService.updateCab(cab,uuid);
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    @DeleteMapping("/delete")
    public ResponseEntity<CabOutPutDTO> deleteCab(@RequestParam("cabId") Integer cabId,
                                         @RequestParam("uuid")String uuid){
        CabOutPutDTO response=cabService.deleteCab(cabId,uuid);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }



}
