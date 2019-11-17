package at.htl.supermarket.model;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Cashier extends Person {
    public LocalDate begin_date;
    public double salary;

    public Cashier() {
    }

    public Cashier(String firstname, String lastname, LocalDate birthdate, String mobilePhone, String email,
                   LocalDate begin_date, double salary) {
        super(firstname, lastname, birthdate, mobilePhone, email);
        this.begin_date = begin_date;
        this.salary = salary;
        //this.person = person;
    }
}
