package io.prajwala.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@NamedQueries({
        @NamedQuery(name    = "Reading.findAll",
                    query   = "SELECT readings FROM Reading readings"),
        @NamedQuery(name    = "Reading.findByVin",
                    query   = "SELECT readings FROM Reading readings WHERE readings.vin = :paramVin")
})
public class Reading {

    @Id
    @Column(columnDefinition = "VARCHAR(36)")
    private String  id;

    private String  vin;
    private Float   latitude;
    private Float   longitude;
    private String  timestamp;
    private Float   fuelVolume;
    private Integer speed;
    private Integer engineHp;
    private Boolean checkEngineLightOn;
    private Boolean engineCoolantLow;
    private Boolean cruiseControlOn;
    private Integer engineRpm;

    @OneToOne(cascade = CascadeType.ALL)
    private TireReadings tires;

    public Reading(){
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Float getFuelVolume() {
        return fuelVolume;
    }

    public void setFuelVolume(Float fuelVolume) {
        this.fuelVolume = fuelVolume;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getEngineHp() {
        return engineHp;
    }

    public void setEngineHp(Integer engineHp) {
        this.engineHp = engineHp;
    }

    public Boolean getCheckEngineLightOn() {
        return checkEngineLightOn;
    }

    public void setCheckEngineLightOn(Boolean checkEngineLightOn) {
        this.checkEngineLightOn = checkEngineLightOn;
    }

    public Boolean getEngineCoolantLow() {
        return engineCoolantLow;
    }

    public void setEngineCoolantLow(Boolean engineCoolantLow) {
        this.engineCoolantLow = engineCoolantLow;
    }

    public Boolean getCruiseControlOn() {
        return cruiseControlOn;
    }

    public void setCruiseControlOn(Boolean cruiseControlOn) {
        this.cruiseControlOn = cruiseControlOn;
    }

    public Integer getEngineRpm() {
        return engineRpm;
    }

    public void setEngineRpm(Integer engineRpm) {
        this.engineRpm = engineRpm;
    }

    public TireReadings getTires() {
        return tires;
    }

    public void setTires(TireReadings tires) {
        this.tires = tires;
    }

    @Override
    public String toString() {
        return "Reading{" +
                "id='" + id + '\'' +
                ", vin='" + vin + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", timestamp='" + timestamp + '\'' +
                ", fuelVolume=" + fuelVolume +
                ", speed=" + speed +
                ", engineHp=" + engineHp +
                ", checkEngineLightOn=" + checkEngineLightOn +
                ", engineCoolantLow=" + engineCoolantLow +
                ", cruiseControlOn=" + cruiseControlOn +
                ", engineRpm=" + engineRpm +
                ", tires=" + tires +
                '}';
    }
}
