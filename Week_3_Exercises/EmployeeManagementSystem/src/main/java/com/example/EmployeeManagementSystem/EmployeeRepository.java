package com.example.EmployeeManagementSystem;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByName(String name);
    List<Employee> findByEmail(String email);
    List<Employee> findByDepartmentId(Long departmentId);
    
        @Query("SELECT e FROM Employee e WHERE e.name LIKE %:name%")
        List<Employee> searchByNameLike(String name);
    
        @Query(name = "Employee.findByName")
        List<Employee> findEmployeesByName(String name);

        @Query(name = "Employee.findByEmail")
        List<Employee> findEmployeesByEmail(String email);
        
        
        
        Page<Employee> findByName(String name, Pageable pageable);
        Page<Employee> findByEmail(String email, Pageable pageable);
        Page<Employee> findByDepartmentId(Long departmentId, Pageable pageable);
		Page<Employee> findAll(java.awt.print.Pageable pageable);

		    List<EmployeeProjection> findByName1(String name);
		    List<EmployeeProjection> findByEmail1(String email);
		    
}

