package service;

import enums.DriverStatus;
import exception.DriverException;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import model.Vehicle;
import rest.server.IpLog;

import java.util.HashSet;
import java.util.List;

@Dependent
public class VehicleService {
    @Inject
    private EntityManager em;

    @Transactional
    public Vehicle createVehicle(Vehicle v, IpLog ipLog) throws DriverException {

        List<Vehicle> vehicles = getAllVehicles();

        if (vehicles.contains(v)) {
            throw new DriverException(DriverStatus.EXISTS.getLabel());
        }
        v.setIpLog(ipLog);
        return em.merge(v);
    }

    @Transactional
    public List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicles = em.createNamedQuery(Vehicle.GET_ALL_VEHICLES, Vehicle.class).getResultList();
        return vehicles;
    }

}
