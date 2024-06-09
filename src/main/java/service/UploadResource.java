//package service;
//
//import java.io.IOException;
//import java.util.List;
//
//import jakarta.enterprise.context.RequestScoped;
//import jakarta.inject.Inject;
//import jakarta.ws.rs.Consumes;
//import jakarta.ws.rs.POST;
//import jakarta.ws.rs.Path;
//import jakarta.ws.rs.core.MediaType;
//import jakarta.ws.rs.core.Response;
//import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
//import org.eclipse.microprofile.openapi.annotations.media.Schema;
//import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
//import org.jboss.logging.Logger;
//import org.jboss.resteasy.reactive.MultipartForm;
//import org.jboss.resteasy.reactive.RestForm;
//import org.jboss.resteasy.reactive.multipart.FileUpload;
//
//@RequestScoped
//@Path("upload")
//public class UploadResource {
//
//    private static final Logger LOG = Logger.getLogger(UploadResource.class.getName());
//
//    @Inject
//    FileService fileService;
//
//    @POST
//    @Consumes(MediaType.MULTIPART_FORM_DATA)
//    @APIResponse(responseCode = "202")
//    public Response upload(@MultipartForm MultipartBody body) throws IOException {
//
//        LOG.info("upload() quantity of files + " + body.files.size());
//
//        for (FileUpload file : body.files) {
//            LOG.info("filePath " + file.filePath());
//            String targetPath = "C:\\Users\\Korisnik\\Desktop\\img quarkus\\fileName.png";
//            fileService.processFile(file.filePath(), targetPath);
//        }
//
//        LOG.info("upload() before response Accepted");
//
//        return Response.accepted().build();
//    }
//
//    @Schema(type = SchemaType.STRING, format = "binary")
//    public interface UploadItemSchema {
//    }
//
//    public class UploadFormSchema {
//        public List<UploadItemSchema> files;
//    }
//
//    @Schema(implementation = UploadFormSchema.class)
//    public static class MultipartBody {
//        @RestForm("files")
//        public List<FileUpload> files;
//    }
//
//}