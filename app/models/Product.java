package models;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import play.data.validation.Constraints;
import javax.persistence.*;
import play.db.ebean.Model;

/**
 * Created by fkitema on 10/15/2017.
 */
@Entity
public class Product extends Model {

    private static List<Product> products;
    static {
        products = new ArrayList<Product>();
        products.add(new Product("1111111111111", "Paperclips 1",
                "Paperclips description 1"));
        products.add(new Product("2222222222222", "Paperclips 2",
                "Paperclips description 2"));
        products.add(new Product("3333333333333", "Paperclips 3",
                "Paperclips description 3"));
        products.add(new Product("4444444444444", "Paperclips 4",
                "Paperclips description 4"));
        products.add(new Product("5555555555555", "Paperclips 5",
                "Paperclips description 5"));
    }

    @Id
    public Long id;
    @Constraints.Required
    public String ean;
    @Constraints.Required
    public String name;
    public String description;
    @OneToMany(mappedBy="product")
    public List<StockItem> stockItems;
    @ManyToMany
    public List<Tag> tags = new LinkedList<Tag>();

    public static Finder<Long, Product> find() {
        return new Finder<Long, Product>(Long.class, Product.class);
    }

    /*public static Finder<Long, Product> find =
            new Finder<>(Long.class, Product.class); */

    public Product() {}
    public Product(String ean, String name, String description) {
        this.ean = ean;
        this.name = name;
        this.description = description;
    }
    public String toString() {
        return String.format("%s - %s", ean, name);
    }


    public static List<Product> findAll() {
        return new ArrayList<Product>(products);
    }
    public static Product findByEan(String ean) {
        for (Product candidate : products) {
            if (candidate.ean.equals(ean)) {
                return candidate;
            }
        }
        return null;
    }
    public static List<Product> findByName(String term) {
        final List<Product> results = new ArrayList<Product>();
        for (Product candidate : products) {
            if (candidate.name.toLowerCase().contains(term.toLowerCase())) {
                results.add(candidate);
            }
        }
        return results;
    }
    public static boolean remove(Product product) {
        return products.remove(product);
    }

 /*   public void save() {
        products.remove(findByEan(this.ean));
        products.add(this);
    }*/



}
