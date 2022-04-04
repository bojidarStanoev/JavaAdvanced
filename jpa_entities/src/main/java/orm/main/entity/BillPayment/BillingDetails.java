package orm.main.entity.BillPayment;

import orm.main.entity.hospital.Base;

import javax.persistence.*;

@Entity(name="billing_details")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BillingDetails extends Base {
    @Column(nullable = false,unique = true)
    private long number;
    @OneToOne
    private User owner;

    public BillingDetails() {
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
