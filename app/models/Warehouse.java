package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fkitema on 11/30/2017.
 */
public class Warehouse {
    public String name;
    public List<StockItem> stock = new ArrayList<>();
    public String toString() {
        return name;
    }
}
