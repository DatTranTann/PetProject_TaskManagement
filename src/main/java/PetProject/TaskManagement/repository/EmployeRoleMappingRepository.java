package PetProject.TaskManagement.repository;

import PetProject.TaskManagement.entity.EmployeRoleMapping;
import PetProject.TaskManagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EmployeRoleMappingRepository extends JpaRepository<EmployeRoleMapping, UUID> {
        @Query(value = "select erm.id, e.display_name, r.role_name, erm.updated_by, erm.updated_date "+
                " from employee_role_mapping erm " +
                "join employee e on e.id  = erm.employee_id " +
                "join \"role\" r on erm.role_id = r.id", nativeQuery = true)
        List<Object> getAllEmployeRoleMapping();
        }
