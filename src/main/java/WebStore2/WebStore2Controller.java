package WebStore2;

import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebStore2Controller
{
    public HashMap<String, Product> products = new HashMap<String, Product>();
    private HashMap<String, Order> orders = new HashMap<String, Order>();

    @RequestMapping("/addNewProduct")
    public String addNewProduct(@RequestParam(value="name") String name,
                                 @RequestParam(value="description") String description,
                                 @RequestParam(value="price") int price,
                                 @RequestParam(value="stock") int stock)
    {
        String nameTemplate = "%s";
        String descriptionTemplate = "%s";

        if (!this.products.containsKey(name))
        {
            Product newProduct = new Product(String.format(nameTemplate, name),
                                             String.format(descriptionTemplate, description),
                                             price,
                                             stock);

            this.products.put(name, newProduct);
            return newProduct.toString();
        }
        else
        {
            return "The Product " + name + " is already in stock.";
        }
    }

    @RequestMapping("/removeProduct")
    public String removeProduct(@RequestParam(value="name") String name)
    {
        if (this.products.containsKey(name))
        {
            this.products.remove(name);
            return "Product " + name + " has been removed from stock.";
        }
        else
        {
            return "Product " + name + " is not in stock.";
        }
    }

    @RequestMapping("/updateProductName")
    public String updateProductName(@RequestParam(value="oldName") String oldName,
                                    @RequestParam(value="newName") String newName)
    {
        if (this.products.containsKey(oldName))
        {
            Product p = this.products.get(oldName);
            p.setProductName(newName);
            this.products.remove(oldName);
            this.products.put(newName, p);
            return "Product " +  oldName + "'s new name is " + newName;
        }
        else
        {
            return "Product " + oldName + " is not in stock.";
        }
    }

    @RequestMapping("/updateProductDescription")
    public String updateProductDescription(@RequestParam(value="name") String name,
                                           @RequestParam(value="newDescription") String newDescription)
    {
        if (this.products.containsKey(name))
        {
            this.products.get(name).setProductDescription(newDescription);
            return "Product " + name + "'s description has been updated to " + newDescription;
        }
        else
        {
            return "Product " + name + " is not in stock.";
        }
    }

    @RequestMapping("/updateProductPrice")
    public String updateProductPrice(@RequestParam(value="name") String name,
                                     @RequestParam(value="newPrice") int newPrice)
    {
        if (this.products.containsKey(name))
        {
            this.products.get(name).setPrice(newPrice);
            return "Product " + name + "'s price has been updated to " + newPrice;
        }
        else
        {
            return "Product " + name + " is not in stock.";
        }
    }

    @RequestMapping("/showProducts")
    public Collection<Product> showProducts()
    {
        return this.products.values();
    }

    @RequestMapping("/makeNewOrder")
    public String makeNewOrder(@RequestParam(value="name") String name)
    {
        if (!this.orders.containsKey(name))
        {
            Order newOrder = new Order(name);
            this.orders.put(name, newOrder);
            return "Order " + name + " has been added.";
        }
        else
        {
            return "Order " + name + " doesn't exist.";
        }
    }



}