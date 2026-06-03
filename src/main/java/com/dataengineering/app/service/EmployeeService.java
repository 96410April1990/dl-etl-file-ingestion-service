package com.dataengineering.app.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.CSVFormat;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dataengineering.app.repository.EmployeeFileRepository;
import com.dataengineering.app.entity.EmployeeFile;
import com.dataengineering.app.entity.EmployeeRecord;
import com.dataengineering.app.model.ValidationResult;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.StandardOpenOption;
import org.apache.commons.io.input.BOMInputStream;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class EmployeeService {

    private final EmployeeFileRepository repository;
    @Autowired private ValidationService validationService;

    public EmployeeService(EmployeeFileRepository repository) {
        this.repository = repository;
    }

    public EmployeeFile processFile(MultipartFile fileName) throws IOException {

        String uploadDir = "uploads/";

        Path path = Paths.get(uploadDir + fileName.getOriginalFilename());
        Files.createDirectories(path.getParent());
        Files.write(path, fileName.getBytes());

        List<EmployeeRecord> employees = parseFile(path);
        List<EmployeeRecord> validEmployees = new ArrayList<>();
        List<EmployeeRecord> invalidEmployees = new ArrayList<>();

        for(EmployeeRecord employee: employees) {
            ValidationResult result = validationService.validate(employee);
            if (result.isValid()) {
                validEmployees.add(employee);
                System.out.println("Valid Employee: " + employee.getEmpId() + " " + employee.getName());
            } else {
                invalidEmployees.add(employee);
                System.out.println("Invalid Employee: " + employee.getEmpId() + " - " + employee.getName() + " -> " + result.getReason());
            }
        }

        System.out.println("Valid records = " + validEmployees.size());
        System.out.println("Invalid records = " + invalidEmployees.size());

        EmployeeFile file = 
                new EmployeeFile(fileName.getOriginalFilename(), LocalDateTime.now(), "UPLOADED");

        return repository.save(file);
    }

    private List<EmployeeRecord> parseFile(Path path) throws IOException {
        
        List<EmployeeRecord> employees = new ArrayList<>();
        
        BOMInputStream bomInputStream = new BOMInputStream(Files.newInputStream(path, StandardOpenOption.READ));
        Reader reader = new InputStreamReader(bomInputStream, java.nio.charset.StandardCharsets.UTF_8);

        CSVParser parser = CSVFormat.DEFAULT
            .withFirstRecordAsHeader()
            .withTrim()
            .parse(reader);

        for (CSVRecord csvRecord : parser) {
            EmployeeRecord employee = 
                    new EmployeeRecord( 
                        Long.parseLong(csvRecord.get("empId")), 
                        csvRecord.get("name"), 
                        Double.parseDouble(csvRecord.get("salary")), 
                        csvRecord.get("department"));
            employees.add(employee);
        }
        return employees;
    }
    
}
