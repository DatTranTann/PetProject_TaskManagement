package PetProject.TaskManagement.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Data
@Table(name = "employee_role_mapping")
public class EmployeRoleMapping {
    @jakarta.persistence.Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID Id;

    @Column(name = "is_deleted")
    private boolean IsDeleted;
    @Column(name = "created_date")
    private LocalDateTime CreatedDate;
    @Column(name = "created_by")
    private String CreatedBy;
    @Column(name = "updated_date")
    private LocalDateTime UpdatedDate;
    @Column(name = "updated_by")
    private String UpdatedBy;
    @ManyToOne
    @JoinColumn(name = "role_id") // thông qua khóa ngoại role_id
    private Role role;

    @ManyToOne
    @JoinColumn(name = "employee_id") // thông qua khóa ngoại employee_id
    private Employee employee;
    public EmployeRoleMapping() {}
    public EmployeRoleMapping(UUID id, boolean isDeleted, LocalDateTime createdDate, String createdBy, LocalDateTime updatedDate, String updatedBy)
    {
        this.Id = id;
        this.IsDeleted = isDeleted;
        this.CreatedDate = createdDate;
        this.CreatedBy = createdBy;
        this.UpdatedDate = updatedDate;
        this.UpdatedBy = updatedBy;
    }
}
