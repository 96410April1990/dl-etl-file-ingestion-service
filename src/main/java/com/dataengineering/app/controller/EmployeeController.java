package com.dataengineering.app.controller;

import java.io.IOException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestParam;

import com.dataengineering.app.service.EmployeeService;
import com.dataengineering.app.entity.EmployeeFile;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping("/upload")
    public EmployeeFile uploadFile(
        @RequestParam("file") MultipartFile file) throws IOException {

        return service.processFile(file);
    }
    
}
