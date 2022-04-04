package orm.main.entity.BillPayment;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name="bank_account")
public class BankAccount extends BillingDetails{
    @Column(nullable = false)
    private  String name;
    @Column(name = "swift_code",nullable = false)
    private int swiftCode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSwiftCode() {
        return swiftCode;
    }

    public void setSwiftCode(int swiftCode) {
        this.swiftCode = swiftCode;
    }
}
