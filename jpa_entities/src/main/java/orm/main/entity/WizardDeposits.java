package orm.main.entity;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "wizard_deposit")
public class WizardDeposits {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private  long id;
    @Column(name = "first_name",length = 50)
   private String first_name;
    @Column(name = "last_name",nullable = false,length = 60)
   private String last_name;
    @Column(name = "notes",length = 1000,columnDefinition = "text")
    private String notes;
    @Column(name = "age",nullable = false)
    private int age;
    @Column(name = "magic_wand_creator",length = 100)
    private String magicWandCreator;
    @Column(name = "magic_wand_size")
    private long magicWandSize;
    @Column(name = "deposit_group",length = 20)
    private String depositGroup;
    @Column(name = "deposit_start_date")
    private LocalDateTime depositStartDate;
    @Column(name = "deposit_amount")
    private double depositAmount;
    @Column(name = "deposit_interest")
    private double depositInterest;



    @Column(name = "deposit_charge")
    private double depositCharge;
    @Column(name = "deposit_expiration_date")
    private LocalDateTime depositExpirationDate;
    @Column(name = "is_deposit_expired")
    private boolean isDepositExpired;
    public WizardDeposits() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMagicWandCreator() {
        return magicWandCreator;
    }

    public void setMagicWandCreator(String magicWandCreator) {
        this.magicWandCreator = magicWandCreator;
    }

    public long getMagicWandSize() {
        return magicWandSize;
    }

    public void setMagicWandSize(long magicWandSize) {
        this.magicWandSize = magicWandSize;
    }

    public String getDepositGroup() {
        return depositGroup;
    }

    public void setDepositGroup(String depositGroup) {
        this.depositGroup = depositGroup;
    }

    public LocalDateTime getDepositStartDate() {
        return depositStartDate;
    }

    public void setDepositStartDate(LocalDateTime depositStartDate) {
        this.depositStartDate = depositStartDate;
    }

    public double getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(double depositAmount) {
        this.depositAmount = depositAmount;
    }

    public double getDepositInterest() {
        return depositInterest;
    }

    public void setDepositInterest(double depositInterest) {
        this.depositInterest = depositInterest;
    }

    public double getDepositCharge() {
        return depositCharge;
    }

    public void setDepositCharge(double depositCharge) {
        this.depositCharge = depositCharge;
    }

    public LocalDateTime getDepositExpirationDate() {
        return depositExpirationDate;
    }

    public void setDepositExpirationDate(LocalDateTime depositExpirationDate) {
        this.depositExpirationDate = depositExpirationDate;
    }

    public boolean isDepositExpired() {
        return isDepositExpired;
    }

    public void setDepositExpired(boolean depositExpired) {
        isDepositExpired = depositExpired;
    }
}
