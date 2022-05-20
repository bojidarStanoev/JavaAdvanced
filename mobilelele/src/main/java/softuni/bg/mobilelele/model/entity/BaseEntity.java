package softuni.bg.mobilelele.model.entity;

import javax.persistence.*;
import java.time.Instant;

@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Instant created;
    private Instant modified;

    public Long id() {
        return id;
    }

    public Instant created() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant modified() {
        return modified;
    }

    public void setModified(Instant modified) {
        this.modified = modified;
    }

    public BaseEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @PrePersist
    public void beforeCreated(){
        this.created=Instant.now();
    }
    @PostUpdate
    public void onUpdate(){
        this.modified=Instant.now();
    }

}
