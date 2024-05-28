package model;

import jakarta.persistence.*;
import rest.server.IpLog;
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

    @ManyToMany(mappedBy = "vehicles", fetch = FetchType.EAGER)
    private Set<Driver> drivers;

    public Vehicle(){
        super();
    }

    public Set<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(Set<Driver> drivers) {
        this.drivers = drivers;
    }

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

//    public void setId(Long id) {
//        this.id = id;
//    }

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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((model == null) ? 0 : model.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vehicle other = (Vehicle) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (model == null) {
            if (other.model != null)
                return false;
        } else if (!model.equals(other.model))
            return false;
        return true;
    }


    @Override
    public String toString() {
        return "Vehicle [id=" + id + ", model=" + model + "]";
    }
}
