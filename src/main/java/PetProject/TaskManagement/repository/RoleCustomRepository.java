package PetProject.TaskManagement.repository;

import PetProject.TaskManagement.entity.Employee;
import PetProject.TaskManagement.entity.Role;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.stereotype.Repository;

import org.hibernate.transform.Transformers;
import java.util.List;

@Repository
public class RoleCustomRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Role> getRole (Employee employee){
        StringBuilder sql = new StringBuilder()
                //nếu muốn lấy tên role thì phải as column name = tên field name role trong entity role
                // 1h sáng rồi nên k chạy docker để query db nên viết ý đại nhớ sửa sau nhe Đạt
                .append("select r.name as RoleName from Employee e join userRoleMapping ur on e.id = ur.userId \n"+
                        "join role r on r.id = ur.roleId");
        sql.append("where 1=1");
        if (employee.getEmail() != null){
            sql.append(" and email = :email");
        }

        NativeQuery<Role> query = ((Session) entityManager.getDelegate()) .createNativeQuery(sql.toString());
        if (employee.getEmail() != null){
            query.setParameter("email", employee.getEmail());
        }

        query.addScalar("RoleName", StandardBasicTypes.STRING);
        query.setResultListTransformer(Transformers.aliasToBean(Role.class));
        return query.list();
    }
}
