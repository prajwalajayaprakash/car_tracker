package io.prajwala.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name    = "Vehicle.findAll",
            query   = "SELECT vehicles FROM Vehicle vehicles")
public class Vehicle {

    @Id
    @Column(columnDefinition = "VARCHAR(17)")
    private String  vin;

    private String  make;
    private String  model;
    private Integer year;
    private Integer redlineRpm;
    private Integer maxFuelVolume;
    private String  lastServiceDate;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getRedlineRpm() {
        return redlineRpm;
    }

    public void setRedlineRpm(Integer redlineRpm) {
        this.redlineRpm = redlineRpm;
    }

    public Integer getMaxFuelVolume() {
        return maxFuelVolume;
    }

    public void setMaxFuelVolume(Integer maxFuelVolume) {
        this.maxFuelVolume = maxFuelVolume;
    }

    public String getLastServiceDate() {
        return lastServiceDate;
    }

    public void setLastServiceDate(String lastServiceDate) {
        this.lastServiceDate = lastServiceDate;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vin='" + vin + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", redlineRpm=" + redlineRpm +
                ", maxFuelVolume=" + maxFuelVolume +
                ", lastServiceDate='" + lastServiceDate + '\'' +
                '}';
    }
}
