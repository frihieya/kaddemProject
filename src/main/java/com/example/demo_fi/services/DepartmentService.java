package com.example.demo_fi.services;

import com.example.demo_fi.entities.Department;

import java.util.List;
import java.util.Optional;


public interface DepartmentService {
    List<Department> retrieveAllDepartements();

    Department addDepartement (Department d);

    Department updateDepartement (Department d);

    Optional<Department> retrieveDepartement (Integer idDepart);
}
