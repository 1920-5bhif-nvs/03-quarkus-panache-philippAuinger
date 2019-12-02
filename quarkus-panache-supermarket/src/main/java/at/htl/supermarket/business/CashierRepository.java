package at.htl.supermarket.business;

import at.htl.supermarket.model.Cashier;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class CashierRepository implements PanacheRepository<Cashier> {

    public Cashier save(Cashier newCashier){
        persistAndFlush(newCashier);
        return findById(newCashier.id);
    }

    public Cashier update(Cashier updatedCashier){
        Cashier persistedCashier = findById(updatedCashier.id);
        if(persistedCashier != null) {
            persistedCashier.begin_date = updatedCashier.begin_date;
            persistedCashier.birthdate = updatedCashier.birthdate;
            persistedCashier.email = updatedCashier.email;
            persistedCashier.firstname = updatedCashier.firstname;
            persistedCashier.lastname = updatedCashier.lastname;
            persistedCashier.mobilePhone = updatedCashier.mobilePhone;
            persistedCashier.salary = updatedCashier.salary;
        }

        return persistedCashier;
    }

    public void delete(Cashier toDeleteCashier){
        this.delete("id = ?1",toDeleteCashier.id);
    }

    public List<Cashier> getAll(){
        return findAll().list();
    }
}
