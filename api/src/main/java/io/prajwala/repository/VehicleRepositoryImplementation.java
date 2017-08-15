package io.prajwala.repository;

import io.prajwala.entity.Vehicle;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class VehicleRepositoryImplementation implements VehicleRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Vehicle> findAll() {
        TypedQuery<Vehicle> query = entityManager.createNamedQuery("Vehicle.findAll", Vehicle.class);
        return query.getResultList();

    }

    public Vehicle findOneByVin(String vin) {
        return entityManager.find(Vehicle.class, vin);

    }

    public Vehicle create(Vehicle vehicle) {
        entityManager.persist(vehicle);
        return vehicle;
    }

    public Vehicle update(Vehicle vehicle) {
        entityManager.merge(vehicle);
        return vehicle;
    }


    public void delete(Vehicle vehicle) {
        entityManager.remove(vehicle);
    }
}
