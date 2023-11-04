package ua.deti.ies.EmployeeManagement.service;


import ua.deti.ies.EmployeeManagement.entity.Employee;

import java.util.List;

public interface UserService {
    Employee createemployee(Employee employee);

    Employee getemployeeById(Long employeeId);

    List<Employee> getAllemployee();

    Employee updateemployee(Employee employee);

    void deleteemployee(Long employeeId);

    List<Employee> getfindByEmail(String employeeEmail);
}