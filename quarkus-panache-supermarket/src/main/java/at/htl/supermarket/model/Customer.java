package at.htl.supermarket.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Customer extends Person {
    public LocalDate accession_date;
    public int loyalty_points;
    public int card_number;
    public String rank;

    public Customer() {
    }

    public Customer(String firstname, String lastname, LocalDate birthdate, String mobilePhone, String email,
                    LocalDate accession_date, int loyalty_points, int card_number, String rank) {
        super(firstname, lastname, birthdate, mobilePhone, email);
        this.accession_date = accession_date;
        this.loyalty_points = loyalty_points;
        this.card_number = card_number;
        this.rank = rank;
        //this.person = person;
    }

    @Override
    public String toString() {
        return this.firstname + " " + this.loyalty_points;
    }
}
