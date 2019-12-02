package at.htl.supermarket.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Cashier extends Person {
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
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
