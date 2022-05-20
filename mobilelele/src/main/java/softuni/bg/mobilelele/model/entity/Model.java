package softuni.bg.mobilelele.model.entity;

import javax.persistence.*;

import static javax.persistence.EnumType.STRING;
@Entity
@Table(name = "models")
public class Model extends  BaseEntity{
    @Column(nullable = false)
    private String name;
    @Enumerated(STRING)
    @Column(nullable = false)
    private Category category;
    @Column(name = "start_year",nullable = false)
    private int startYear;
    @Column(name = "end_year")
    private int endYear;
    @Column(name = "image_url")
    private String imageUrl;
    @ManyToOne
    private BrandEntity brand;

    public Model(String name, Category category, int startYear, int endYear, String imageUrl, BrandEntity brand) {
        this.name = name;
        this.category = category;
        this.startYear = startYear;
        this.endYear = endYear;
        this.imageUrl = imageUrl;
        this.brand = brand;
    }

    public Model() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public BrandEntity getBrand() {
        return brand;
    }

    public void setBrand(BrandEntity brand) {
        this.brand = brand;
    }
}
