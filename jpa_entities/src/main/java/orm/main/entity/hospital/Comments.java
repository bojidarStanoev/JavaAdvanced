package orm.main.entity.hospital;

import javax.persistence.Entity;

@Entity(name = "comments")
public class Comments  extends  Base{
    private String comment;

    public Comments() {
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
