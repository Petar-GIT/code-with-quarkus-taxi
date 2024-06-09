package rest.server;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.reactive.RestResponse.Status;

import exception.DriverException;
import model.Driver;
import org.jboss.resteasy.reactive.multipart.FileUpload;
import rest.client.IpClient;
import service.DriverService;
import service.MultipartRequest;

@jakarta.ws.rs.Path("/api/driver/")
public class DriverRest {

    @Inject
    private DriverService driverService;

    @Inject
    @RestClient
    IpClient ipClient;

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @jakarta.ws.rs.Path("/createDriver")
    @Operation(summary = "Web server that creates new driver and uploads a file.",
            description = "Driver has to be unique.")
    public Response createDriver(MultipartRequest multipartRequest){
        Driver driver = multipartRequest.getDriver();
        FileUpload file = multipartRequest.getFile();
//        System.out.println("File name: " + file.fileName());

        String directory = "C:\\Users\\Korisnik\\Desktop\\img quarkus\\";
        Path newFilePath = Paths.get(directory + file.fileName());
        try {
            Files.move(file.uploadedFile(), newFilePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            return Response.serverError().entity("Error saving file: " + e.getMessage()).build();
        }
        driver.setFileName(newFilePath.toString());
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
    @jakarta.ws.rs.Path("/getAllDrivers")
    public Response getAllDrivers() {
        List<Driver> drivers =  driverService.getAllDrivers();
        return Response.ok().entity(drivers).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @jakarta.ws.rs.Path("/getDriversByName")
    public Response getDriversByName(@QueryParam(value = "name") String name) {
        List<Driver> drivers = driverService.getDriversByName(name);
        if (drivers.isEmpty()) {
            return Response.status(Status.NOT_FOUND).entity("No drivers found with the given name.").build();
        }
        Driver driver = drivers.get(0); // or select the appropriate driver
        Path filePath = Paths.get(driver.getFileName());
        byte[] fileContent;
        try {
            fileContent = Files.readAllBytes(filePath);
        } catch (IOException e) {
            return Response.serverError().entity("Error reading file: " + e.getMessage()).build();
        }
        String fileName = filePath.getFileName().toString();
        return Response.ok(fileContent)
                .header("Content-Disposition", "attachment; filename=\"" + fileName + "\"")
                .build();
    }

//    @Inject
//    private FileService fileService;

//    @POST
//    @jakarta.ws.rs.Path("/processFile")
//    @Consumes(MediaType.APPLICATION_OCTET_STREAM)
//    public Response processFile(InputStream inputStream) {
//        String processedFileName = null;
//        try {
//            Path tempFile = Files.createTempFile("upload", ".tmp");
//            Files.copy(inputStream, tempFile, StandardCopyOption.REPLACE_EXISTING);
//            String filePath = "C:\\Users\\Korisnik\\Desktop\\img quarkus";
//            processedFileName = fileService.processFile(tempFile, filePath);
//            return Response.ok(processedFileName).build();
//        } catch (Exception e) {
//            return Response.serverError().entity("Error processing file: " + e.getMessage()).build();
//        }
//    }



}