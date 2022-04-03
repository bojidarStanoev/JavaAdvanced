package orm.main.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity()
@Table(name = "sale")
public class Sale {
    public Sale() {
    }

    @Id
    private int id;
    @ManyToOne
    private Product product;
    @ManyToOne
    private storeLocation storeLocation;
    @ManyToOne
    private Customer customer;
    @Column
    private LocalDateTime date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public orm.main.entity.storeLocation getStoreLocation() {
        return storeLocation;
    }

    public void setStoreLocation(orm.main.entity.storeLocation storeLocation) {
        this.storeLocation = storeLocation;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
