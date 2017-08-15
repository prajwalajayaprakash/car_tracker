package io.prajwala.service;

import io.prajwala.entity.Reading;

import java.util.List;

public interface ReadingService {

    List<Reading> findAll();

    List<Reading> findByVin(String vin);

    Reading create(Reading reading);


}
