package WebStore2;

import java.util.concurrent.atomic.AtomicLong;

public class Product
{
    private String productName;
    private String productDescription;
    private final long id;
    private int price;

    public Product(String productName, String productDescription, long id, int price)
    {
        this.productName = productName;
        this.productDescription = productDescription;
        this.id = id;
        this.price = price;
    }

    public String getProductName()
    {
        return this.productName;
    }

    public String getProductDescription()
    {
        return this.productDescription;
    }

    public long getId()
    {
        return this.id;
    }

    public int getPrice()
    {
        return this.price;
    }

    public void setProductName(String newName)
    {
        this.productName = newName;
    }

    public void setProductDescription(String newDescription)
    {
        this.productDescription = newDescription;
    }

    public void setPrice(int newPrice)
    {
        this.price = newPrice;
    }

    public String toString()
    {
        return this.productName + ", " + this.productDescription + ", " + this.id + ", " + "$" + this.price;
    }
}
