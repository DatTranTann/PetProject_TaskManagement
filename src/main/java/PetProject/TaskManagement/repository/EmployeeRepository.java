package PetProject.TaskManagement.repository;
import PetProject.TaskManagement.entity.Employee;
import PetProject.TaskManagement.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
    @Query(value = "select * from employee where lower(user_name) like ?1%", nativeQuery = true)
    List<Employee> getListRoleByName(@Param("userName") String userName);
}
