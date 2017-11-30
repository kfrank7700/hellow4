package models;

import play.db.ebean.Model;

import javax.persistence.*;


/**
 * Created by fkitema on 11/30/2017.
 */

@Entity
public class StockItem extends Model {
    @Id
    public Long id;
    public Warehouse warehouse;
    @ManyToOne
    public Product product;
    public Long quantity;
    public String toString() {
        return String.format("%d %s", quantity, product);
    }
}

