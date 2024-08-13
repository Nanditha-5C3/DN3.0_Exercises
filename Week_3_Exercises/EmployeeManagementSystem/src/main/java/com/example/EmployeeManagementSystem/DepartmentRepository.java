package com.example.EmployeeManagementSystem;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findByName(String name);
    List<DepartmentProjection> findbyName(String name);
    
@Query("SELECT d FROM Department d WHERE d.name LIKE %:name%")
Department searchByNameLike(String name);


}
