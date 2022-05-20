package softuni.bg.mobilelele.model.entity;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name="brands")
public class BrandEntity extends BaseEntity {


    private String name;

@OneToMany(cascade = CascadeType.ALL,mappedBy = "brand")
private List<Model> models;

    public BrandEntity() {
    }

    public String getName() {
        return name;
    }

    public BrandEntity setName(String name) {
        this.name = name;
        return this;
    }



    public List<Model> models() {
        return models;
    }

    public void setModels(List<Model> models) {
        this.models = models;
    }





}
