package io.prajwala.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@NamedQueries({
        @NamedQuery(name    = "Alert.findAllAlerts",
                    query   = "SELECT alerts FROM Alert alerts"),
        @NamedQuery(name    = "Alert.highAlerts",
                    query   = "SELECT alerts FROM Alert alerts WHERE alerts.priority = :paramPriority"),
        @NamedQuery(name    = "Alert.alertsByVin",
                    query   = "SELECT alerts FROM Alert alerts WHERE alerts.vin = :paramVin"),
        @NamedQuery(name    = "Alert.highAlertsByVin",
                    query   = "SELECT alerts FROM Alert alerts WHERE alerts.priority = 'HIGH' AND alerts.vin = :paramVin")
        })
public class Alert {

    @Id
    @Column(columnDefinition = "VARCHAR(36)")
    private String id;

    private String timestamp;
    private String vin;
    private String alertReason;
    private String priority;

    public Alert(){}

    public Alert(String vin, String timestamp, String alertReason, String priority){
        this.id = UUID.randomUUID().toString();
        this.vin = vin;
        this.timestamp = timestamp;
        this.alertReason = alertReason;
        this.priority = priority;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        id = id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getAlertReason() {
        return alertReason;
    }

    public void setAlertReason(String alertReason) {
        this.alertReason = alertReason;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Alert{" +
                "id='" + id + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", vin='" + vin + '\'' +
                ", alertReason='" + alertReason + '\'' +
                ", priority='" + priority + '\'' +
                '}';
    }
}
