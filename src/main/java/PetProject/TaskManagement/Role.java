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
    private String RoleName;
    private boolean IsDeleted;
    private LocalDateTime CreatedDate;
    private UUID  CreatedBy;
    private LocalDateTime UpdatedDate;
    private UUID  UpdatedBy;
    public Role() {}
    public Role(UUID Id, String RoleName, boolean IsDeleted, LocalDateTime CreatedDate, UUID CreatedBy, LocalDateTime UpdatedDate, UUID UpdatedBy)
    {
        super();
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

