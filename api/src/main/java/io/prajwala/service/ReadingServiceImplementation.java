package io.prajwala.service;

import io.prajwala.entity.Alert;
import io.prajwala.entity.Reading;
import io.prajwala.entity.Vehicle;
import io.prajwala.exceptions.ResourceNotFoundException;
import io.prajwala.repository.AlertRepository;
import io.prajwala.repository.ReadingRepository;
import io.prajwala.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ReadingServiceImplementation implements ReadingService {

    @Autowired
    ReadingRepository readingRepository;
    @Autowired
    VehicleRepository vehicleRepository;
    @Autowired
    AlertRepository alertRepository;

    @Transactional(readOnly = true)
    public List<Reading> findAll() {
        return readingRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Reading> findByVin(String vin) {
        List<Reading> existing = readingRepository.findByVin(vin);
        if(existing == null){
            //Exception handling 404
            throw new ResourceNotFoundException("Car with Vin: " + vin + " does not exist.");
        } else {
            return existing;
        }
    }

    @Transactional
    public Reading create(Reading reading) {
        Optional<Vehicle> currentVehicle = Optional.ofNullable(vehicleRepository.findOneByVin(reading.getVin()));
        currentVehicle.ifPresent(vehicle -> {
            createAlert(reading, vehicle);
        });
        return readingRepository.create(reading);
    }

    //Checking for Alerts Logic
    public void createAlert(Reading reading, Vehicle vehicle){
        if(reading.getEngineRpm() > vehicle.getRedlineRpm()){
            Alert alert = new Alert(vehicle.getVin(), reading.getTimestamp(), "EngineRPM High", "HIGH");
            alertRepository.create(alert);
        }
        if(reading.getFuelVolume() < (0.1)*(vehicle.getMaxFuelVolume())){
            Alert alert = new Alert(vehicle.getVin(), reading.getTimestamp(), "Fuel Volume Low", "MEDIUM");
            alertRepository.create(alert);
        }
        if(reading.getTires().getFrontLeft() < 32 || reading.getTires().getFrontRight() < 32 ||
                reading.getTires().getRearLeft() < 32 || reading.getTires().getRearRight() < 32){
            Alert alert = new Alert(vehicle.getVin(), reading.getTimestamp(), "Tire Pressure Low", "LOW");
            alertRepository.create(alert);
        }
        if(reading.getTires().getFrontLeft() > 36 || reading.getTires().getRearRight() > 36 ||
                reading.getTires().getRearLeft() > 36 || reading.getTires().getRearRight() > 36){
            Alert alert = new Alert(vehicle.getVin(), reading.getTimestamp(), "Tire Pressure High", "LOW");
            alertRepository.create(alert);
        }
        if(reading.getEngineCoolantLow() == true){
            Alert alert = new Alert(vehicle.getVin(), reading.getTimestamp(),"Engine Coolant Low", "LOW");
            alertRepository.create(alert);
        }
        if(reading.getCheckEngineLightOn() == true){
            Alert alert = new Alert(vehicle.getVin(), reading.getTimestamp(),"Check Engine Light On","LOW");
            alertRepository.create(alert);
        }
    }
}
