package io.prajwala.controller;

import io.prajwala.entity.Vehicle;
import io.prajwala.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/vehicles")
public class VehicleController {

    @Autowired
    VehicleService service;

    @RequestMapping(method = RequestMethod.GET)
    public List<Vehicle> findAll(){

        return service.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{vin}")
    public Vehicle findOneByVin(@PathVariable("vin") String vehicleVin){

        return service.findOneByVin(vehicleVin);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Vehicle create(@RequestBody Vehicle vehicle){

        return service.create(vehicle);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public List<Vehicle> update(@RequestBody List<Vehicle> vehicles){

        return service.update(vehicles);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{vin}")
    public void delete(@PathVariable("vin") String vehicleVin){
        service.delete(vehicleVin);
    }

}
