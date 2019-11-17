package at.htl.supermarket.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Storage extends PanacheEntity {

    @JsonbTransient
    @OneToMany(mappedBy = "storage", fetch= FetchType.EAGER)
    private List<Product> products = new ArrayList<>();

    public Storage(){}

}
