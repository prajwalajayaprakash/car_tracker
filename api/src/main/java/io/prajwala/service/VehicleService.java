package io.prajwala.service;

import io.prajwala.entity.Vehicle;

import java.util.List;

public interface VehicleService {

    List<Vehicle> findAll();

    Vehicle findOneByVin(String vin);

    Vehicle create(Vehicle vehicle);

    List<Vehicle> update(List<Vehicle> vehicle);

    void delete(String vin);
}
