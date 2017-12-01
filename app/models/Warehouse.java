package models;

import play.db.ebean.Model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fkitema on 11/30/2017.
 */
@Entity
public class Warehouse{
    @Id
    public Long id;
    public String name;
    @OneToOne
    public Address address;
    @OneToMany(mappedBy = "warehouse")
    public List<StockItem> stock = new ArrayList<>();
    @Override
    public String toString() {
        return name;
    }
}

