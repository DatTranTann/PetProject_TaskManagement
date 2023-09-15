package PetProject.TaskManagement.controller;

import PetProject.TaskManagement.entity.EmployeRoleMapping;
import PetProject.TaskManagement.entity.Employee;
import PetProject.TaskManagement.service.EmployeRoleMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/employeRoleMapping")
@CrossOrigin("http://localhost:8080")
public class EmployeRoleMappingController {
    @Autowired
    private EmployeRoleMappingService employeRoleMappingService;
    @GetMapping("/")
    public List<Object> getListEmployeRoleMapping() {
        List<Object> listEmployeRoleMapping = employeRoleMappingService.getAll();
        return listEmployeRoleMapping;
    }

    @GetMapping("/id/{id}")
    public EmployeRoleMapping getEmployeeById(@PathVariable("id") UUID id) {
        return employeRoleMappingService.get(id);
    }
}
