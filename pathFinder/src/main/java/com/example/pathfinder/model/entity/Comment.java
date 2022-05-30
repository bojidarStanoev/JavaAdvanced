package com.example.pathfinder.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name="comments")
public class Comment  extends BaseEntity{
    private Boolean approved;
    @ManyToOne
    private Route route;
    @Column(columnDefinition = "TEXT")
    private String textContent;
    private LocalDateTime created;
    @ManyToOne
    private User author;

    public Comment() {
    }

    public Boolean approved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public Route route() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public String textContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public LocalDateTime created() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public User author() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
