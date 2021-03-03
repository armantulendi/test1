package com.example.demo.repo;

import com.example.demo.second.Employee;

public interface EmployeeDao {
    Employee findEmployee();
    void insertEmployee(Employee e);

}
