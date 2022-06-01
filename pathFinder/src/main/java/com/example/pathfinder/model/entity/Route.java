package com.example.pathfinder.model.entity;

import com.example.pathfinder.model.entity.enums.LevelEnum;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "routes")
public class Route extends BaseEntity{
@Column(unique = true,nullable = false)
    private String name;
@Enumerated(EnumType.STRING)
    private LevelEnum level;
@Column(columnDefinition = "LONGTEXT")
private String gpxCoordinates;
@ManyToOne
private User author;
@Column(columnDefinition = "TEXT")
private String description;
private String videoUrl;
@ManyToMany
private Set<Category> categories;
    public String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LevelEnum level() {
        return level;
    }

    public void setLevel(LevelEnum level) {
        this.level = level;
    }


    public String gpxCoordinates() {
        return gpxCoordinates;
    }

    public void setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
    }

    public Set<Category> categories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public User author() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String description() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String videoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
