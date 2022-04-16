package softuni.exam.models.dto;

import softuni.exam.models.entity.Apartment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "apartments")
@XmlAccessorType(XmlAccessType.FIELD)
public class ApartmentSeedRootDto {
@XmlElement(name = "apartment")
    private List<ApartmentSeedDto> apartment;

    public List<ApartmentSeedDto> getApartment() {
        return apartment;
    }

    public void setApartment(List<ApartmentSeedDto> apartment) {
        this.apartment = apartment;
    }
}
