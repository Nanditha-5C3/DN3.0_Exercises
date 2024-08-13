package com.example.EmployeeManagementSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository empRepo;

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return empRepo.save(employee);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Optional<Employee> employee = empRepo.findById(id);
        return employee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return empRepo.findAll();
    }

    @GetMapping
    public Page<Employee> getAllEmployees(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) Long departmentId,
            @PageableDefault(size = 10, page = 0, sort = "name") Pageable pageable) {
        if (name != null) {
            return empRepo.findByName(name,
                    (org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable) pageable);
        } else if (email != null) {
            return empRepo.findByEmail(email,
                    (org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable) pageable);
        } else if (departmentId != null) {
            return empRepo.findByDepartmentId(departmentId,
                    (org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable) pageable);
        } else {
            return empRepo.findAll(pageable);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        if (!empRepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        employee.setId(id);
        Employee updatedEmployee = empRepo.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        if (!empRepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        empRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}