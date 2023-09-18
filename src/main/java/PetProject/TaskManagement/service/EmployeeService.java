package PetProject.TaskManagement.service;
import PetProject.TaskManagement.Interface.ServiceInterface.EmployeeServiceInterface;
import PetProject.TaskManagement.entity.Employee;
import PetProject.TaskManagement.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeeService implements EmployeeServiceInterface {
    @Autowired
    private EmployeeRepository repo;

    private final PasswordEncoder passwordEncoder;
    public List<Employee> getAllEmployees()
    {
        return repo.findAll();
    }
    public Employee getEmployeeById(UUID id)
    {
        return repo.findById(id).get();
    }
    public List<Employee> getEmployeeByUserName(String userName) {
        var employeeValue = repo.getListRoleByName(userName);
        return employeeValue;
    }
    public void create(Employee employee){
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        repo.save(employee);
    }
    public void update(Employee employee){
        if (getEmployeeById(employee.getId()) != null)
        {
            repo.save(employee);
        }
        else {
            create(employee);
        }
    }
    public String delete(UUID id) {
//        var employee = repo.findById(id).get();
//        if (employee != null)
//        {
//            employee.setDeleted(true);
//            repo.save(employee);
//            return "Delete employee successfully";
//        }
//        else {
//            return "Cant Find Employee!!";
//        }
        return "";
    }
}
