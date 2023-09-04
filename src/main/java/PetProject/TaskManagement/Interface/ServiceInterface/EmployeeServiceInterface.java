package PetProject.TaskManagement.Interface.ServiceInterface;

import PetProject.TaskManagement.entity.Employee;

import java.util.List;
import java.util.UUID;

public interface EmployeeServiceInterface {
     List<Employee> getAllEmployees();
     Employee getEmployeeById(UUID id);
     void create(Employee employee);
     void update(Employee employee);
     String delete(UUID id);
}
