package PetProject.TaskManagement.controller;
import PetProject.TaskManagement.entity.Employee;
import PetProject.TaskManagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/employee")
@CrossOrigin("http://localhost:8080")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/")
    public List<Employee> getListEmployees(Model model) {
        List<Employee> listRoles = employeeService.getAllEmployees();
        return listRoles;
    }
    @GetMapping("/id/{id}")
    public Employee getEmployeeById(@PathVariable("id") UUID id) {
        return employeeService.getEmployeeById(id);
    }
    @GetMapping("/name/{name}")
    public List<Employee> getEmployeeByUserName(@PathVariable("name") String name) {
        return employeeService.getEmployeeByUserName(name);
    }




    @PostMapping("/employee")
    public void CreateUpdateEmployee(Employee employee) {
    }
    @DeleteMapping("/employee")
    public String DeleteEmployee(UUID id)
    {
        return employeeService.delete(id);
    }
}
