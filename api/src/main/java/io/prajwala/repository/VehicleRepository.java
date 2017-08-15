package io.prajwala.repository;

import io.prajwala.entity.Vehicle;

import java.util.List;

public interface VehicleRepository {

    List<Vehicle> findAll();

    Vehicle findOneByVin(String vin);

    Vehicle create(Vehicle vehicle);

    Vehicle update(Vehicle vehicle);

    void delete(Vehicle vehicle);
}
