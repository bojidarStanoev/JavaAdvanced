package com.example.pathfinder.model.entity;

import com.example.pathfinder.model.entity.enums.CategoryNameEnum;

import javax.persistence.*;

@Entity
@Table(name="categories")
public class Category extends BaseEntity{
    @Enumerated(EnumType.STRING)
    private CategoryNameEnum name;
    @Column(columnDefinition = "LONGTEXT")
    private String description;
    public Category() {
    }

    public String description() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CategoryNameEnum name() {
        return name;
    }

    public void setName(CategoryNameEnum name) {
        this.name = name;
    }
}
