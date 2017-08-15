package io.prajwala.repository;

import io.prajwala.entity.Alert;

import java.util.List;

public interface AlertRepository {

    List<Alert> findAllAlerts();

    List<Alert> highAlerts();

    List<Alert> alertsByVin(String vin);

    List<Alert> highAlertsByVin(String vin);

    Alert create(Alert alert);
}
