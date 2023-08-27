package PetProject.TaskManagement;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleService {
    @Autowired
    private RoleRepository repo;

    public List<Role> listAll() {
        return repo.findAll();
    }

    public void save(Role role) {
        repo.save(role);
    }

    public Role get(UUID id) {
        return repo.findById(id).get();
    }

    public void delete(UUID id) {
        repo.deleteById(id);
    }
}
