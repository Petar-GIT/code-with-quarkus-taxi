package service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import jakarta.enterprise.context.ApplicationScoped;
import org.jboss.logging.Logger;

import io.quarkus.vertx.ConsumeEvent;

@ApplicationScoped
public class FileService {

    private static final Logger LOG = Logger.getLogger(FileService.class.getName());

    public void processFile(Path sourcePath, String targetPath) throws IOException {

        LOG.info("processFile() begin");

        try {
            Files.copy(sourcePath, Paths.get(targetPath), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            LOG.error("Error", e);
        }

        LOG.info("processFile() end");

    }

}