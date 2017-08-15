package io.prajwala.repository;

import io.prajwala.entity.Reading;

import java.util.List;

public interface ReadingRepository {

    List<Reading> findAll();

    List<Reading> findByVin(String vin);

    Reading create(Reading reading);
}
