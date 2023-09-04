package PetProject.TaskManagement.service;
import PetProject.TaskManagement.Interface.ServiceInterface.EmployeeServiceInterface;
import PetProject.TaskManagement.entity.Employee;
import PetProject.TaskManagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EmployeeService implements EmployeeServiceInterface {
    @Autowired
    private EmployeeRepository repo;

    public List<Employee> getAllEmployees()
    {
        return repo.findAll();
    }
    public Employee getEmployeeById(UUID id)
    {
        return repo.findById(id).get();
    }
    public void create(Employee employee){
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
        var employee = repo.findById(id).get();
        if (employee != null)
        {
            employee.setDeleted(true);
            repo.save(employee);
            return "Delete employee successfully";
        }
        else {
            return "Cant Find Employee!!";
        }
    }
}
