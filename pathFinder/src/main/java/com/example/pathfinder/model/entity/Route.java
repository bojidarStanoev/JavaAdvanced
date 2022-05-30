package com.example.pathfinder.model.entity;

import com.example.pathfinder.model.entity.enums.LevelEnum;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Route extends BaseEntity{
@Column(unique = true,nullable = false)
    private String name;
@Enumerated(EnumType.ORDINAL)
    private LevelEnum level;
@Column(columnDefinition = "LONGTEXT")
private String gpxCoordinate;
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

    public String gpxCoordinate() {
        return gpxCoordinate;
    }

    public void setGpxCoordinate(String gpxCoordinate) {
        this.gpxCoordinate = gpxCoordinate;
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
