package io.prajwala.service;

import io.prajwala.entity.Vehicle;
import io.prajwala.exceptions.BadRequestException;
import io.prajwala.exceptions.ResourceNotFoundException;
import io.prajwala.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VehicleServiceImplementation implements VehicleService {

    @Autowired
    VehicleRepository repository;

    @Transactional(readOnly = true)
    public List<Vehicle> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Vehicle findOneByVin(String vin) {
        Vehicle existing = repository.findOneByVin(vin);
        if(existing == null){
            //Exception Handling 404
            throw new ResourceNotFoundException("Car with Vin: " + vin + " does not exist");
        }
        return existing;
    }

    @Transactional
    public Vehicle create(Vehicle vehicle) {
        Vehicle existing = repository.findOneByVin(vehicle.getVin());
        if(existing != null){
            //Exception Handling 400
            throw new BadRequestException("Car with Vin: " + vehicle.getVin() + " already exists." );
        }
        return repository.create(vehicle);
    }

    @Transactional
    public List<Vehicle> update(List<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            Vehicle existing = repository.findOneByVin(vehicle.getVin());
            if (existing == null) {
                repository.create(vehicle);
            } else {
                repository.update(vehicle);
            }
        }
        return vehicles;
    }

    @Transactional
    public void delete(String vin) {
        Vehicle existing = repository.findOneByVin(vin);
        if(existing == null){
            //Exception Handling 404
            throw new ResourceNotFoundException("Car with Vin: " + vin + " does not exist.");
        }
        repository.delete(existing);
    }
}
