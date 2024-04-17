package service;

import java.util.HashSet;
import java.util.List;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import enums.DriverStatus;
import exception.DriverException;
import model.Driver;
import model.Phone;

@Dependent
public class DriverService {

    @Inject
    private EntityManager em;

    @Transactional
    public Driver createDriver(Driver d) throws DriverException {

        List<Driver> drivers = getAllDrivers();

        if (drivers.contains(d)) {
            throw new DriverException(DriverStatus.EXISTS.getLabel());
        }

        return em.merge(d);
    }

    @Transactional
    public List<Driver> getAllDrivers() {
        List<Driver> drivers = em.createNamedQuery(Driver.GET_ALL_DRIVERS, Driver.class).getResultList();

        for (Driver driver : drivers) {
            List<Phone> phones = getAllForDriver(driver);
            driver.setPhones(new HashSet<>(phones));
        }

        return drivers;
    }

    @Transactional
    public List<Phone> getAllForDriver(Driver d) {
        return em.createNamedQuery(Phone.GET_ALL_FOR_DRIVER, Phone.class).setParameter("id", d.getId())
                .getResultList();
    }

    @Transactional
    public List<Driver> getDriversByName(String name) {
        List<Driver> drivers = em.createNamedQuery(Driver.GET_DRIVERS_BY_NAME, Driver.class)
                .setParameter("name", name).getResultList();

        for (Driver driver : drivers) {
            List<Phone> phones = getAllForDriver(driver);
            driver.setPhones(new HashSet<>(phones));
        }

        return drivers;

    }

}