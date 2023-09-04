package PetProject.TaskManagement.controller;
import PetProject.TaskManagement.entity.Employee;
import PetProject.TaskManagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.UUID;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/ListEmployees")
    public String getListEmployees(Model model) {
        List<Employee> listRoles = employeeService.getAllEmployees();
        model.addAttribute("listRoles", listRoles);
        return "listRoles";
    }
    @GetMapping("/employee")
    public Employee getEmployeeById(UUID id) {
        return employeeService.getEmployeeById(id);
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
