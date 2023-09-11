package PetProject.TaskManagement.service;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;

import PetProject.TaskManagement.entity.Role;
import PetProject.TaskManagement.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleService {
    @Autowired
    private RoleRepository repo;

    public List<Role> getAll() {
        return repo.findAll();
    }
    public Optional<Role> getRoleById(UUID id) {
        return repo.findById(id);
    }
    public List<Role> getRoleByName(String name) {
        var roleValue = repo.getListRoleByName(name);
        return roleValue;
    }

    public void save() {
        UUID randomUUID = UUID.randomUUID();
        UUID userId = UUID.fromString("00000000-0000-0000-0000-000000000000");
        LocalDateTime dateTime = LocalDateTime.of(2023, Month.AUGUST, 31, 15, 30);
        Role role1 = new Role(randomUUID, "Dat Admin",true,dateTime,userId,dateTime,userId);
        repo.save(role1);
    }

    public Role get(UUID id) {
        return repo.findById(id).get();
    }

    public void delete(UUID id) {
        repo.deleteById(id);
    }
}
