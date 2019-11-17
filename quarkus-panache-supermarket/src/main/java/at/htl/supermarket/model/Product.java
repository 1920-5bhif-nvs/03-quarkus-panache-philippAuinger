package at.htl.supermarket.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Product extends PanacheEntity {
    public String name;
    public String brand;
    public double price;
    public LocalDate best_before_date;
    public int quantity;

    @ManyToOne()
    public Storage storage;

    public Product() {
    }

    public Product(String name, double price, LocalDate best_before_date, String brand, int quantity, Storage storage) {
        this.name = name;
        this.price = price;
        this.best_before_date = best_before_date;
        this.brand = brand;
        this.quantity = quantity;
        this.storage = storage;
    }
}
