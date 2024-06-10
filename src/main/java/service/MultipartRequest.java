package service;


import model.Driver;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.jboss.resteasy.reactive.PartType;
import org.jboss.resteasy.reactive.RestForm;
import org.jboss.resteasy.reactive.multipart.FileUpload;

import jakarta.ws.rs.core.MediaType;



public class MultipartRequest {
    @RestForm("file")
    @PartType(MediaType.APPLICATION_OCTET_STREAM)
    @Schema(implementation = MultipartResource.UploadSchema.class)
    private FileUpload file;

//    @RestForm("name")
//    @PartType(MediaType.TEXT_PLAIN)
//    private String name;

    @RestForm("driver")
    @PartType(MediaType.APPLICATION_JSON)
    private Driver driver;

    public FileUpload getFile() {
        return file;
    }

    public void setFile(FileUpload file) {
        this.file = file;
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }


}

