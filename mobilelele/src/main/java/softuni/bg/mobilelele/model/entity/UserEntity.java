package softuni.bg.mobilelele.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name="users")
public class UserEntity extends  BaseEntity{
    @Column(nullable = false,unique = true)
    private String username;

    @Column(nullable = false)
    private String firstname;
    @Column(nullable = false)
    private String lastname;
    private boolean isActive;
    @ManyToMany
    private List<Roles> roles;
    private String password;

    public String username() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public String firstname() {
        return firstname;
    }

    public UserEntity setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String lastname() {
        return lastname;
    }

    public UserEntity setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public boolean isActive() {
        return isActive;
    }

    public UserEntity setActive(boolean active) {
        isActive = active;
        return this;
    }

    public List<Roles> roles() {
        return roles;
    }

    public UserEntity setRoles(List<Roles> roles) {
        this.roles = roles;
        return this;
    }

    public String password() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }
}
