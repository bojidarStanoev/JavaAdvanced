package orm.main.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "teacher")
public class Teacher extends User{
    @Column
    private String email;
    @Column(name = "salary_per_hour")
    private BigDecimal salaryPerHour;

    public String getEmail() {
        return email;
    }
    @OneToMany()
    private Set<Course> courses;
    public Teacher() {
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalaryPerHour(BigDecimal salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }
}
