package PetProject.TaskManagement.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.time.LocalDateTime;
import java.util.*;

@Entity
@Getter @Setter
@Table(name = "employee")
public class Employee implements UserDetails {
    @jakarta.persistence.Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID Id;
    @Column(name = "first_name")
    private String FirstName;
    @Column(name = "last_name")
    private String LastName;
    @Column(name = "user_name")
    private String UserName;
    @Column(name = "password")
    private String Password;
    @Column(name = "display_name")
    private String DisplayName;
    @Column(name = "email")
    private String Email;
    @Column(name = "last_login_date")
    private LocalDateTime LastLoginDate;
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

    @OneToMany(mappedBy="employee")
//    private Collection<EmployeRoleMapping> employeRoleMappings;
    private Set<EmployeRoleMapping>employeRoleMappings;

    public Employee() {}
    public Employee(UUID id, String firstName, String lastName, String userName, String password, String displayName, String Email, LocalDateTime lastLoginDate, boolean isDeleted, LocalDateTime createdDate, String createdBy, LocalDateTime updatedDate, String updatedBy)
    {
        this.Id = id;
        this.FirstName = firstName;
        this.LastName = lastName;
        this.UserName = userName;
        this.Password = password;
        this.DisplayName = displayName;
        this.Email = Email;
        this.LastLoginDate = lastLoginDate;
        this.IsDeleted = isDeleted;
        this.CreatedDate = createdDate;
        this.CreatedBy = createdBy;
        this.UpdatedDate = updatedDate;
        this.UpdatedBy = updatedBy;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        employeRoleMappings.stream().forEach(i -> authorities.add(new SimpleGrantedAuthority(i.getRole().getRoleName())));
        return List.of(new SimpleGrantedAuthority(authorities.toString()));
    }

    @Override
    public String getUsername() {
        return Email;
    }
    @Override
    public String getPassword() {
        return Password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
//    public UUID getId() {
//        return id;
//    }
//    public void setId(UUID id) {
//        this.id = id;
//    }
//    public String getFirstName() {
//        return firstName;
//    }
//    public void getFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//    public String getLastName() {
//        return lastName;
//    }
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
}
