package WebStore2;

import java.util.HashSet;

public class Order
{
    private final long id;
    private HashSet<Product> products = new HashSet<Product>();
    private boolean confirmed;

    public Order(long id, Product product)
    {
        this.id = id;
        this.products.add(product);
    }

    public long getId()
    {
        return this.id;
    }

    public HashSet<Product> getProducts()
    {
        return this.products;
    }

    public boolean isConfirmed()
    {
        return this.confirmed;
    }

    public void addProduct(Product newProduct)
    {
        this.products.add(newProduct);
    }

    public void confirmOrder()
    {
        if(this.confirmed == false)
        {
            this.confirmed = true;
        }
    }
}
