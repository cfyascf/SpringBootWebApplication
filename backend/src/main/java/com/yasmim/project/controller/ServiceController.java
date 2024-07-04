package com.yasmim.project.controller;

import com.yasmim.project.dto.RegisterServiceData;
import com.yasmim.project.entity.ServiceData;
import com.yasmim.project.service.JWTService;
import com.yasmim.project.service.ServiceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @Autowired
    private JWTService jwtService;

    @PostMapping("/service")
    public ResponseEntity<ServiceData> registerService(
            @RequestBody RegisterServiceData obj,
            @RequestHeader("Authorization") String jwt) {

        jwtService.verifyPermission(jwt, 1);

        return ResponseEntity.ok(serviceService.registerService(obj));
    }

    @GetMapping("/service")
    public ResponseEntity<List<ServiceData>> getService(
            @RequestParam String query,
            @RequestParam Integer index,
            @RequestParam Integer size,
            @RequestHeader("Authorization") String jwt) {

        jwtService.verifyPermission(jwt, null);

        return new ResponseEntity<>(
                serviceService.getPaginatedServices(query, index, size),
                HttpStatus.OK);
    }
}
