package at.htl.supermarket.business;

import at.htl.supermarket.model.Product;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProductRepository implements PanacheRepository<Product> {
    
}
