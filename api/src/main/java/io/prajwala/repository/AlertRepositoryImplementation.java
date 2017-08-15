package io.prajwala.repository;

import io.prajwala.entity.Alert;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class AlertRepositoryImplementation implements AlertRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Alert> findAllAlerts() {
        TypedQuery<Alert> query = entityManager.createNamedQuery("Alert.findAllAlerts", Alert.class);
        List<Alert> resultList  = query.getResultList();
        System.out.println(countAlert(resultList) + " Total Alerts");;
        return resultList;
    }

    public List<Alert> highAlerts() {
        TypedQuery<Alert> query = entityManager.createNamedQuery("Alert.highAlerts", Alert.class);
        query.setParameter("paramPriority", "HIGH");
        List<Alert> resultList  = query.getResultList();
        System.out.println(countAlert(resultList) + " High Alerts");
        return resultList;
    }

    public List<Alert> alertsByVin(String vin) {
        TypedQuery<Alert> query = entityManager.createNamedQuery("Alert.alertsByVin", Alert.class);
        query.setParameter("paramVin", vin);
        List<Alert> resultList  = query.getResultList();
        if(resultList != null && resultList.size() >= 1){
            System.out.println(countAlert(resultList) + " Alerts");
            return resultList;
        } else {
            return null;
        }

    }

    public List<Alert> highAlertsByVin(String vin) {
        TypedQuery<Alert> query = entityManager.createNamedQuery("Alert.highAlertsByVin", Alert.class);
        query.setParameter("paramVin", vin);
        List<Alert> resultList  = query.getResultList();
        if(resultList != null && resultList.size() >= 1){
            System.out.println(countAlert(resultList) + " Alerts");
            return resultList;
        } else {
            return null;
        }

    }

    public Alert create(Alert alert) {
        entityManager.persist(alert);
        return alert;
    }

    //Logging number of alerts to console
    //Will be returned to user while developing User Interface
    public int countAlert(List<Alert> resultList){
        int count = 0;
        for(int i = 0; i < resultList.size(); i++){
            count += i;
        }
        return count;
    }
}
