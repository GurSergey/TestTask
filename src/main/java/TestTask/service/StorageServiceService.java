package TestTask.service;

import TestTask.rest.StorageService;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Repository
public class StorageServiceService implements StorageService {
    @Override
    public void store(MultipartFile file) {
        final String dir = System.getProperty("user.dir");

        Path filepath = Paths.get(dir+"/files/", file.getOriginalFilename());

        try (OutputStream os = Files.newOutputStream(filepath)) {
            os.write(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
