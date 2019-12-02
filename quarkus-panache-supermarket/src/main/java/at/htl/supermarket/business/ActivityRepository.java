package at.htl.supermarket.business;

import at.htl.supermarket.model.Activity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ActivityRepository implements PanacheRepository<Activity> {
    public List<Activity> getSoldProductsSortedByDate(){
        return findAll(Sort.by("time").descending()).list();
    }
}
