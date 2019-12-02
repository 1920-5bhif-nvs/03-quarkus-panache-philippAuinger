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

    public Cashier update(Cashier updatedCashier){
        this.save(updatedCashier);
        return findById(updatedCashier.id);
    }

    public void delete(Cashier toDeleteCashier){
        delete(toDeleteCashier);
    }
}
