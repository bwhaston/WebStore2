package WebStore2;

import java.util.HashSet;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebStore2Controller
{
    private final AtomicLong counter = new AtomicLong();
    private HashSet<Product> products = new HashSet<Product>();
    private HashSet<Order> orders = new HashSet<Order>();

    @RequestMapping("/addNewProduct")
    public Product addNewProduct(@RequestParam(value="name") String name,
                                 @RequestParam(value="description") String description,
                                 @RequestParam(value="price") int price) {
        String nameTemplate = "%s";
        String descriptionTemplate = "%s";
        Product newProduct = new Product(String.format(nameTemplate, name),
                String.format(descriptionTemplate, description),
                counter.incrementAndGet(),
                price);

        if (!this.products.contains(newProduct)) {
            this.products.add(newProduct);
        }

        return newProduct;
    }
}