package com.yasmim.project.service;

import com.yasmim.project.entity.DepartmentData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentService {
    public List<DepartmentData> getAllDepartments();
    public DepartmentData findDepartmentByName(String name);
}
