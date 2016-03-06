package WebStore2;

import java.util.Collection;
import java.util.HashMap;

public class Order
{
    private String name;
    private HashMap<String, Product> products = new HashMap<String, Product>();
    private int orderTotal;

    public Order(String name)
    {
        this.name = name;
    }

    public Collection<Product> getProducts()
    {
        return this.products.values();
    }

    public void addProduct(Product newProduct)
    {
        this.products.put(newProduct.getProductName(), newProduct);
        this.orderTotal += newProduct.getPrice();
    }
}
