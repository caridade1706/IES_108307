package ua.deti.ies.EmployeeManagement.controller;


import lombok.AllArgsConstructor;
import ua.deti.ies.EmployeeManagement.entity.Employee;
import ua.deti.ies.EmployeeManagement.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/employee")

public class UserController {

    private UserService userService;

    // build create User REST API
    @PostMapping
    public ResponseEntity<Employee> createemployee(@RequestBody Employee employee){
        Employee savedemployee = userService.createemployee(employee);
        return new ResponseEntity<>(savedemployee, HttpStatus.CREATED);
    }

    // build get user by id REST API
    // http://localhost:8080/api/users/1
    @GetMapping("{id}")
    public ResponseEntity<Employee> getUseremployeeId(@PathVariable("id") Long employeeId){
        Employee employee = userService.getemployeeById(employeeId);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    // Build Get All Users REST API
    // http://localhost:8080/api/users
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployes(@RequestParam(defaultValue = "none") String email){

       
        List<Employee> employee;

        if (email.equals("none")) {
            employee = userService.getAllemployee();
        }
        else {
            employee = userService.getfindByEmail(email);
        }
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    // Build Update User REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/users/1
    public ResponseEntity<Employee> updateUser(@PathVariable("id") Long employeeId,
                                           @RequestBody Employee employee){
                                            employee.setId(employeeId);
        Employee updatedUser = userService.updateemployee(employee);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    // Build Delete User REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long employeeId){
        userService.deleteemployee(employeeId);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }
    
}
