package rest.server;


import java.util.List;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.reactive.RestResponse.Status;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import exception.DriverException;
import model.Driver;
import rest.client.CountryClient;
import rest.client.IpClient;
import service.DriverService;

@Path("/api/driver/")
public class DriverRest {

    @Inject
    private DriverService driverService;

    @Inject
    @RestClient
    IpClient ipClient;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/createDriver")
    @Operation(summary = "Web server that creates new driver.",
            description = "Driver has to be unique.")
    public Response createDriver(Driver driver){
        Driver d = null;
        try {
           IpLog i = ipClient.getIp();
           d = driverService.createDriver(driver, i);
        } catch (DriverException e) {
            return Response.status(Status.CONFLICT).entity(e.getMessage()).build();
        }
        return Response.ok().entity(d).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAllDrivers")
    public Response getAllDrivers() {
        List<Driver> drivers =  driverService.getAllDrivers();
        return Response.ok().entity(drivers).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getDriversByName")
    public Response getDriversByName(@QueryParam(value = "name") String name) {

        System.out.println("NAME QUERY PARAMETER: " + name);
        List<Driver> drivers =  driverService.getDriversByName(name);
        return Response.ok().entity(drivers).build();
    }



}