package orm.main.entity.BillPayment;

import orm.main.entity.hospital.Base;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity(name = "user")
public class User extends Base {
    @Column(name = "first_name",length = 60,nullable = false)
    private String firstName;
    @Column(name = "last_name",length = 60,nullable = false)
    private String lastName;
    @Column(nullable = false,unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @OneToOne()
    private BillingDetails billingDetails;

    public User() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BillingDetails getBillingDetails() {
        return billingDetails;
    }

    public void setBillingDetails(BillingDetails billingDetails) {
        this.billingDetails = billingDetails;
    }
}
