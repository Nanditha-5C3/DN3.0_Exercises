package com.example.EmployeeManagementSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentRepository deptRepo;

    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
        return deptRepo.save(department);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Long id) {
        Optional<Department> dept = deptRepo.findById(id);
        return dept.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Department> getAllDepartments() {
        return deptRepo.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable Long id, @RequestBody Department department) {
        if (!deptRepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        department.setId(id);
        Department updatedDepartment = deptRepo.save(department);
        return ResponseEntity.ok(updatedDepartment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable Long id) {
        if (!deptRepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        deptRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
