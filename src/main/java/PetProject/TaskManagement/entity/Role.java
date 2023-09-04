package PetProject.TaskManagement.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID Id;
    @Column(name = "role_name")
    private String RoleName;
    @Column(name = "is_deleted")
    private boolean IsDeleted;
    @Column(name = "created_date")
    private LocalDateTime CreatedDate;
    @Column(name = "created_by")
    private UUID  CreatedBy;
    @Column(name = "updated_date")
    private LocalDateTime UpdatedDate;
    @Column(name = "updated_by")
    private UUID  UpdatedBy;
    public Role() {}
    public Role(UUID id, String roleName, boolean isDeleted, LocalDateTime createdDate, UUID createdBy, LocalDateTime updatedDate, UUID updatedBy)
    {
        this.Id = id;
        this.RoleName = roleName;
        this.IsDeleted = isDeleted;
        this.CreatedDate = createdDate;
        this.CreatedBy = createdBy;
        this.UpdatedDate = updatedDate;
        this.UpdatedBy = updatedBy;
    }
    public UUID getId() {
        return Id;
    }

    public String getRoleName() {
        return RoleName;
    }
}

