package io.prajwala.controller;

import io.prajwala.entity.Reading;
import io.prajwala.service.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/readings")
public class ReadingController {

    @Autowired
    ReadingService service;

    @RequestMapping(method = RequestMethod.GET)
    public List<Reading> findAll(){
        return service.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{vin}")
    public List<Reading> findByVin(@PathVariable("vin") String vehicleVin){
        return service.findByVin(vehicleVin);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Reading create(@RequestBody Reading reading){
        return service.create(reading);
    }



}
