package WebStore2;

import java.util.HashMap;
import java.util.Set;

public class Order
{
    private String name;
    private HashMap<String, Integer> products = new HashMap<String, Integer>();
    private int orderTotal;

    public Order(String name)
    {
        this.name = name;
    }

    public Set<String> getProducts()
    {
        return this.products.keySet();
    }

    public void addProduct(Product newProduct, int stock)
    {
        this.products.put(newProduct.getProductName(), stock);
        this.orderTotal += newProduct.getPrice();
    }
}
