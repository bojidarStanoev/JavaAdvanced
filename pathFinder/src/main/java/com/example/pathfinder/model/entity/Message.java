package com.example.pathfinder.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name =  "messages")
public class Message extends BaseEntity{
    @Column(nullable = false)
    private LocalDateTime dateTime;
    @Column(nullable = false,columnDefinition = "TEXT")
    private String textContent;
    @ManyToOne
    private User author;
    @ManyToOne
    private User recipient;

    public Message() {
    }

    public LocalDateTime dateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String textContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public User author() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public User recipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }
}
