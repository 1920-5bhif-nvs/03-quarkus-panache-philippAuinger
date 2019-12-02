package at.htl.supermarket.business;

import at.htl.supermarket.model.Cashier;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CashierRepository implements PanacheRepository<Cashier> {

    public Cashier save(Cashier newCashier){
        persistAndFlush(newCashier);
        return findById(newCashier.id);
    }
}
