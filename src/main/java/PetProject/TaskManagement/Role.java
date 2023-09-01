package PetProject.TaskManagement;

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
    public Role(UUID Id, String RoleName, boolean IsDeleted, LocalDateTime CreatedDate, UUID CreatedBy, LocalDateTime UpdatedDate, UUID UpdatedBy)
    {
        this.Id = Id;
        this.RoleName = RoleName;
        this.IsDeleted = IsDeleted;
        this.CreatedDate = CreatedDate;
        this.CreatedBy = CreatedBy;
        this.UpdatedDate = UpdatedDate;
        this.UpdatedBy = UpdatedBy;
    }
    public UUID getId() {
        return Id;
    }

    public String getRoleName() {
        return RoleName;
    }
}

