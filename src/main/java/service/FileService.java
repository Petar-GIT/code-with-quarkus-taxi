//package service;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.nio.file.StandardCopyOption;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//
//import jakarta.enterprise.context.ApplicationScoped;
//import org.jboss.logging.Logger;
//
//import io.quarkus.vertx.ConsumeEvent;
//
//@ApplicationScoped
//public class FileService {
//
//    private static final Logger LOG = Logger.getLogger(FileService.class.getName());
//
//    public String processFile(Path sourcePath, String targetDirectory) throws IOException {
//        LOG.info("processFile() begin");
//        String newFileName = null;
//
//        try {
//            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
//            String originalFileName = sourcePath.getFileName().toString();
//            newFileName = originalFileName.substring(0, originalFileName.lastIndexOf(".")) + "_" + timestamp + ".png";
//            Path targetPath = Paths.get(targetDirectory, newFileName);
//            Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
//        } catch (IOException e) {
//            LOG.error("Error", e);
//        }
//
//        LOG.info("processFile() end");
//        return newFileName;
//    }
//}