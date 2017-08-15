package io.prajwala.repository;

import io.prajwala.entity.Reading;
import io.prajwala.entity.Vehicle;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ReadingRepositoryImplementation implements ReadingRepository{

    @PersistenceContext
    private EntityManager entityManager;

    public List<Reading> findAll() {
        TypedQuery<Reading> query = entityManager.createNamedQuery("Reading.findAll", Reading.class);
        return query.getResultList();
    }

    public List<Reading> findByVin(String vin) {
        TypedQuery<Reading> query = entityManager.createNamedQuery("Reading.findByVin", Reading.class);
        query.setParameter("paramVin",vin);
        List<Reading> resultList = query.getResultList();
        if(resultList != null && resultList.size() >= 1){
            return resultList;
        } else {
            return null;
        }

    }

    public Reading create(Reading reading) {
        entityManager.persist(reading);
        return reading;
    }
}
