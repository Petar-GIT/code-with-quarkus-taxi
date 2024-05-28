package model;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.*;
import rest.server.IpLog;

@Entity
@NamedQueries({
        @NamedQuery(name = Driver.GET_ALL_DRIVERS, query = "Select d from Driver d"),
        @NamedQuery(name = Driver.GET_DRIVERS_BY_NAME, query = "Select d from Driver d where d.name = :name")
})
public class Driver {

    public static final String GET_ALL_DRIVERS = "getAllDrivers";
    public static final String GET_DRIVERS_BY_NAME = "getDriversByName";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "driver_seq")
    private Long id;

    private String name;

    private String surname;

    private Date dateOfBirth;

    private String jmbg;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "driver_id")
    private Set<Phone> phones;

    @OneToOne(cascade = CascadeType.ALL)
    private IpLog ipLog;

    @ManyToMany
    @JoinTable(
            name = "driver_vehicle",
            joinColumns = @JoinColumn(name = "driver_id"),
            inverseJoinColumns = @JoinColumn(name = "vehicle_id")
    )
    private Set<Vehicle> vehicles;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Set<Phone> getPhones() {
        return phones;
    }

    public void setPhones(Set<Phone> phones) {
        this.phones = phones;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((jmbg == null) ? 0 : jmbg.hashCode());
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
        Driver other = (Driver) obj;
        if (jmbg == null) {
            if (other.jmbg != null)
                return false;
        } else if (!jmbg.equals(other.jmbg))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Driver [id=" + id + ", ime=" + name + ", prezime=" + surname + "]";
    }

    public IpLog getIpLog() {
        return ipLog;
    }

    public void setIpLog(IpLog ipLog) {
        this.ipLog = ipLog;
    }
}