package orm.main.entity.hospital;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Set;

@Entity
public class Visitation extends Base {
    @Column
    private LocalDateTime date;
    @ManyToMany
    private Set<Comments> comments;
    public Visitation(Set<Comments> comments) {
        this.comments = comments;
    }

    public Visitation() {
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Set<Comments> getComments() {
        return comments;
    }

    public void setComments(Set<Comments> comments) {
        this.comments = comments;
    }
}
