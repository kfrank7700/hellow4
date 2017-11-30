package controllers;
import com.avaje.ebean.Ebean;
import models.StockItem;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.products.*;
import models.Product;
import models.Tag;
import java.util.ArrayList;
import java.util.List;
import play.data.Form;
import play.mvc.With;



/**
 * Created by fkitema on 10/15/2017.
 */

public class Products extends Controller {
    private static final Form<Product> productForm = Form
            .form(Product.class);

    public static Result index() {

        return redirect(routes.Products.list(0));
    }

    public static Result list(Integer page) {
        List<Product> products = Product.findAll();
        return ok(list.render(products));
    }

    public static Result newProduct() {
        return ok(details.render(productForm));
    }

    public static Result details(String ean) {
        final Product product = Product.findByEan(ean);
        if (product == null) {
            return notFound(String.format("Product %s does not exist.", ean));
        }
        Form<Product> filledForm = productForm.fill(product);
        return ok(details.render(filledForm));
    }

    public static Result save() {
        Form<Product> boundForm = productForm.bindFromRequest();
        if(boundForm.hasErrors()) {
            flash("error", "Please correct the form below.");
            return badRequest(details.render(boundForm));
        }
        Product product = boundForm.get();
        List<Tag> tags = new ArrayList<Tag>();
        for (Tag tag : product.tags) {
            if (tag.id != null) {
                tags.add(Tag.findById(tag.id));
            }
        }
        product.tags = tags;

        StockItem item = new StockItem();
        item.quantity = 0L;
        item.product = product;

        //product.save();
        Ebean.save(product);
        item.save();
        flash("success",
                String.format("Successfully added product %s", product));
        return redirect(routes.Products.list(1));

    }

    public static Result delete(String ean) {
        final Product product = Product.findByEan(ean);
        if(product == null) {
            return notFound(String.format("Product %s does not exists.", ean));
        }
        Product.remove(product);
        return redirect(routes.Products.list(1));
    }

}
