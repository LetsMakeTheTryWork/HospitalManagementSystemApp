package com.abby.hms.service;

import com.abby.hms.model.Department;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);
    Department getDepartmentById(Long id);
    List<Department> getAllDepartments();
    void deleteDepartment(Long id);
    Department updateDepartment(Long id, Department departmentDetails);
}
