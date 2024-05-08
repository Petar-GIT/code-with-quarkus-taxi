package model;

import jakarta.persistence.*;

import rest.server.IpLog;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.Set;

@Entity
@NamedQueries({
        @NamedQuery(name = Vehicle.GET_ALL_VEHICLES, query = "Select v from Vehicle v")
})
public class Vehicle {

    public static final String GET_ALL_VEHICLES = "getAllVehicles";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vehicle_seq")
    private Long id;

    @ManyToMany(mappedBy = "vehicles")
    private Set<Driver> drivers;

    private String location;

    private String licensePlateNumber;

    private String vehicleNumber;

    private double tariff;

    private String model;


    @OneToOne(cascade = CascadeType.ALL)
    private IpLog ipLog;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public void setLicensePlateNumber(String licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public double getTariff() {
        return tariff;
    }

    public void setTariff(double tariff) {
        this.tariff = tariff;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    public IpLog getIpLog() {
        return ipLog;
    }

    public void setIpLog(IpLog ipLog) {
        this.ipLog = ipLog;
    }


}
