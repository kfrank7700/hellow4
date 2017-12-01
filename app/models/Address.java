package models;
import javax.persistence.*;

/**
 * Created by fkitema on 12/1/2017.
 */
@Entity
public class Address {
    @Id
    public Long id;
    @OneToOne
    public Warehouse warehouse;
    public String street;
    public String number;
    public String postalCode;
    public String city;
    public String country;
}
