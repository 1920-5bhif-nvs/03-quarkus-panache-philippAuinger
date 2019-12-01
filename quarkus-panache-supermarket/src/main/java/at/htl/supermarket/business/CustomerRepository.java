package at.htl.supermarket.business;

import at.htl.supermarket.model.Customer;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class CustomerRepository implements PanacheRepository<Customer> {

    public List<Customer> getAllSortedByLoyalityPoints(){
        return findAll(Sort.by("loyality_points")).list();
    }

}
