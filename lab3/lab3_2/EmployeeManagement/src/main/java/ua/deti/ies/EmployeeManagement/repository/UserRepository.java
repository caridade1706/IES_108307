package ua.deti.ies.EmployeeManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.deti.ies.EmployeeManagement.entity.Employee;

public interface UserRepository extends JpaRepository<Employee, Long> {
    //@Query("SELECT * FROM employees e WHERE e.email = :email")
    List<Employee> findByEmail(String email);
}


