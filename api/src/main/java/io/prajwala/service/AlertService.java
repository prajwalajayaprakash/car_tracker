package io.prajwala.service;

import io.prajwala.entity.Alert;

import java.util.List;

public interface AlertService {

    List<Alert> findAllAlerts();

    List<Alert> highAlerts();

    List<Alert> alertsByVin(String vin);

    List<Alert> highAlertsByVin(String vin);

    Alert create(Alert alert);
}
