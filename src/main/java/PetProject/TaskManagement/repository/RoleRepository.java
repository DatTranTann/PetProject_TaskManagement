package PetProject.TaskManagement.repository;
import PetProject.TaskManagement.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface RoleRepository  extends JpaRepository<Role, UUID> {
    @Query(value = "select * from role where lower(role_name) like ?1%", nativeQuery = true)
    List<Role> getListRoleByName(@Param("name") String name);
}
