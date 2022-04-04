package orm.main.entity.BillPayment;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.Date;

@Entity(name = "credit_card")
public class CreditCard extends BillingDetails{
    @Column(nullable = false)
    private String type;
    @Column(name= "expiration_month",nullable = false)
    private Date expMonth;
    @Column(name="expiration_year",nullable = false)
    private Date expYear;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getExpMonth() {
        return expMonth;
    }

    public void setExpMonth(Date expMonth) {
        this.expMonth = expMonth;
    }

    public Date getExpYear() {
        return expYear;
    }

    public void setExpYear(Date expYear) {
        this.expYear = expYear;
    }
}
