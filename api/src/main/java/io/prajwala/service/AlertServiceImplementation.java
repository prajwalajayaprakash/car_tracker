package io.prajwala.service;

import io.prajwala.entity.Alert;
import io.prajwala.entity.Vehicle;
import io.prajwala.exceptions.ResourceNotFoundException;
import io.prajwala.repository.AlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AlertServiceImplementation implements AlertService {

    @Autowired
    AlertRepository repository;

    @Transactional(readOnly = true)
    public List<Alert> findAllAlerts() {
        return repository.findAllAlerts();
    }

    @Transactional(readOnly = true)
    public List<Alert> highAlerts() {
        return repository.highAlerts();
    }

    @Transactional(readOnly = true)
    public List<Alert> alertsByVin(String vin) {
        List<Alert> existing = repository.alertsByVin(vin);
        if(existing == null){
            //Exception Handling 404
            throw new ResourceNotFoundException("Car with Vin: " + vin + " does not exist.");
        }
        return repository.alertsByVin(vin);
    }

    @Transactional(readOnly = true)
    public List<Alert> highAlertsByVin(String vin){
        List<Alert> existing = repository.highAlertsByVin(vin);
        if(existing == null){
            //Exception Handling 404
            throw new ResourceNotFoundException("Car with Vin: " + vin + " does not exist.");
        }
        return repository.highAlertsByVin(vin);
    }

    @Transactional
    public Alert create(Alert alert) {
        return repository.create(alert);
    }
}
