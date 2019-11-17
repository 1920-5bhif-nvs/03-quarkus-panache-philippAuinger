package at.htl.supermarket.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

@Entity
public class Activity extends PanacheEntity {
    public LocalDateTime time;
    public int cashDesk;

    @OneToOne
    public Product product;
    @OneToOne
    public Cashier cashier;
    @OneToOne
    public Customer customer;

    public Activity() {
    }

    public Activity(LocalDateTime time, int cashDesk, Product product, Cashier cashier, Customer customer) {
        this.time = time;
        this.cashDesk = cashDesk;
        this.product = product;
        this.cashier = cashier;
        this.customer = customer;
    }
}
