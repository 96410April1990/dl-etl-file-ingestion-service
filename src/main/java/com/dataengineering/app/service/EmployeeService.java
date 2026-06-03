package com.dataengineering.app.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dataengineering.app.repository.EmployeeFileRepository;
import com.dataengineering.app.entity.EmployeeFile;

@Service
public class EmployeeService {

    private final EmployeeFileRepository repository;

    public EmployeeService(EmployeeFileRepository repository) {
        this.repository = repository;
    }

    public EmployeeFile processFile(MultipartFile fileName) throws IOException {

        String uploadDir = "uploads/";

        Path path = Paths.get(uploadDir + fileName.getOriginalFilename());
        Files.createDirectories(path.getParent());
        Files.write(path, fileName.getBytes());

        EmployeeFile file = 
                new EmployeeFile(fileName.getOriginalFilename(), LocalDateTime.now(), "UPLOADED");

        return repository.save(file);
    }
    
}
