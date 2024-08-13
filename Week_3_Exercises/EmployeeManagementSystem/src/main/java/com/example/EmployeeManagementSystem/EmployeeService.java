package com.example.EmployeeManagementSystem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository empRepo;

    @Transactional
    public void batchInsert(List<Employee> emps) {
        int batchSize = 50;
        for (int i = 0; i < emps.size(); i++) {
            empRepo.save(emps.get(i));
            if (i % batchSize == 0 && i > 0) {
                empRepo.flush(); // Flush a batch of inserts
            }
        }
    }
}
