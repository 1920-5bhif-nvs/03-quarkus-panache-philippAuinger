package at.htl.supermarket.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
public abstract class Person extends PanacheEntity {

    public String firstname;
    public String lastname;
    public LocalDate birthdate;
    public String mobilePhone;
    public String email;

    public Person() {
    }

    public Person(String firstname, String lastname, LocalDate birthdate, String mobilePhone, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.mobilePhone = mobilePhone;
        this.email = email;
    }
}
