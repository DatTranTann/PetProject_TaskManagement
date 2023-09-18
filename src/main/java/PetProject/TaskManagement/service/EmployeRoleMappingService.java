package PetProject.TaskManagement.service;

import PetProject.TaskManagement.entity.EmployeRoleMapping;
import PetProject.TaskManagement.entity.Role;
import PetProject.TaskManagement.repository.EmployeRoleMappingRepository;
import PetProject.TaskManagement.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class EmployeRoleMappingService {
    @Autowired
    private EmployeRoleMappingRepository repo;
    public List<Object> getAll() {
        var result = repo.getAllEmployeRoleMapping();
        return result;
    }
    public Optional<EmployeRoleMapping> getRoleById(UUID id) {
        return repo.findById(id);
    }
    public EmployeRoleMapping get(UUID id) {
        return repo.findById(id).get();
    }

    public void delete(UUID id) {
        repo.deleteById(id);
    }

}
