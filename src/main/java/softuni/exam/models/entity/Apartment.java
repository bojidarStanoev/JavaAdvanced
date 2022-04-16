package softuni.exam.models.entity;

import javax.persistence.*;

@Entity(name = "apartments")
public class Apartment extends BaseEntity{
    @Column(name = "apartment_type")
    @Enumerated(EnumType.STRING)
    private ApartmentType apartmentType;
    @Column(precision = 2)
    private Double area;
    @ManyToOne
    private Town town;

    public ApartmentType getApartmentType() {
        return apartmentType;
    }

    public void setApartmentType(ApartmentType apartmentType) {
        this.apartmentType = apartmentType;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }
}
