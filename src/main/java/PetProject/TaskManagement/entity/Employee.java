package PetProject.TaskManagement.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "employee")
public class Employee {
    @jakarta.persistence.Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID Id;
    @Column(name = "first_name")
    private String FirstName;
    @Column(name = "last_name")
    private String LastName;
    @Column(name = "user_name")
    private String UserName;
    @Column(name = "display_name")
    private String DisplayName;
    @Column(name = "last_login_date")
    private LocalDateTime LastLoginDate;
    @Column(name = "is_deleted")
    private String IsDeleted;
    @Column(name = "created_date")
    private LocalDateTime CreatedDate;
    @Column(name = "created_by")
    private String CreatedBy;
    @Column(name = "updated_date")
    private LocalDateTime UpdatedDate;
    @Column(name = "updated_by")
    private String UpdatedBy;

    public Employee() {}
}
