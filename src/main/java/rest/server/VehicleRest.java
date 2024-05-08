package rest.server;

import exception.DriverException;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.Driver;
import model.Vehicle;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.reactive.RestResponse;
import rest.client.IpClient;
import service.VehicleService;


import java.util.List;
@Path("/api/vehicle/")
public class VehicleRest {
    @Inject
    private VehicleService vehicleService;

    @Inject
    @RestClient
    IpClient ipClient;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/createVehicle")
    @Operation(summary = "Web server that creates new vehicle.",
            description = "Vehicle has to be unique.")
    public Response createVehicle(Vehicle vehicle) throws DriverException {
        Vehicle v = null;
        try {
            IpLog i = ipClient.getIp();
            v = vehicleService.createVehicle(vehicle, i);
        } catch (DriverException e) {
            return Response.status(RestResponse.Status.CONFLICT).entity(e.getMessage()).build();
        }
        return Response.ok().entity(v).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAllVehicles")
    public Response getAllVehicles() {
        List<Vehicle> vehicles =  vehicleService.getAllVehicles();
        return Response.ok().entity(vehicles).build();
    }


}
