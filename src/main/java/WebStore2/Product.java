package WebStore2;

import java.util.concurrent.atomic.AtomicLong;

public class Product
{
    private String productName;
    private String productDescription;
    private int price;
    int totalStock;

    public Product(String productName, String productDescription, int price, int stock)
    {
        this.productName = productName;
        this.productDescription = productDescription;
        this.price = price;
        this.totalStock = stock;
    }

    public String getProductName()
    {
        return this.productName;
    }

    public String getProductDescription()
    {
        return this.productDescription;
    }

    public int getPrice()
    {
        return this.price;
    }

    public int getTotalStock()
    {
        return this.totalStock;
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

    public void addToTotalStock(int addedStock)
    {
        this.totalStock += addedStock;
    }

    public void removeStock(int removedStock)
    {
        if (removedStock >= this.totalStock)
        {
            this.totalStock = 0;
        }
        else
        {
            this.totalStock -= removedStock;
        }
    }

    public String toString()
    {
        return this.productName + ", " + this.productDescription + ", " + "$" + this.price;
    }
}
