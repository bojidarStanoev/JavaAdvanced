package orm.main.entity.hospital;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "medicament")
public class Medicament extends Base{
    @Column
    private String name;

    public Medicament() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
