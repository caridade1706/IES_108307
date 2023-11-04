package ua.deti.ies.EmployeeManagement.service.impl;

import lombok.AllArgsConstructor;
import ua.deti.ies.EmployeeManagement.entity.Employee;
import ua.deti.ies.EmployeeManagement.repository.UserRepository;
import ua.deti.ies.EmployeeManagement.service.UserService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public Employee createemployee(Employee user) {
        return userRepository.save(user);
    }

    @Override
    public Employee getemployeeById(Long userId) {
        Optional<Employee> optionalUser = userRepository.findById(userId);
        return optionalUser.get();
    }
    
    @Override
    public List<Employee> getAllemployee() {
        return userRepository.findAll();
    }

    @Override
    public Employee updateemployee(Employee user) {
        Employee existingUser = userRepository.findById(user.getId()).get();
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        Employee updatedUser = userRepository.save(existingUser);
        return updatedUser;
    }

    @Override
    public void deleteemployee(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public List<Employee> getfindByEmail(String employeeEmail) {
        if (Strings.isBlank(employeeEmail)) {
            throw new IllegalArgumentException("Email cannot be empty");
        }
        return userRepository.findByEmail(employeeEmail);
    }

    
}
