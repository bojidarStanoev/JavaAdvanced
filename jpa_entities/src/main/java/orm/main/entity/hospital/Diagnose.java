package orm.main.entity.hospital;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity(name = "diagnose")
public class Diagnose extends Base{
    @Column
    private String name;
    @ManyToMany
    private Set<Comments> comments;

    public Diagnose() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Comments> getComments() {
        return comments;
    }

    public void setComments(Set<Comments> comments) {
        this.comments = comments;
    }
}
