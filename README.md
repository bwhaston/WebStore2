This is a version of the web store front assignment. It uses Spring's ability to send GET requests to modify Product and Order data.
While this usage of GET is not idempotent (that is to say, usage of GET should not modify the program's state, but in this case, it does) 
I was still able to implement most of the requested functionality.

The way that you interact with this program is via URL query strings. Request parameters that are a part of the query string
correspond to Java methods that change program state depending on what parameters are a part of the query string.

For example, if I wanted to add a Product to the list of all products in the web store, then I'd send the query string:

http://localhost:8080/addNewProduct?name=Macbook Pro&description=This is a good machine to run Linux on&price=1500&stock=1000

This query string will send a GET request, and the the WebStore2Controller class will instantiate a new Product with the attributes
that the user past to the query string and then will add that Product to the list of current Products in stock.

Other features include:

- Removing products from inventory.
- Adding units of a Product that is in stock.
- Removing units of a Product that is in stock.
- Updating a particular Product's name, description, price, and current units in stock.
- Showing the current inventory (represented as a JSON object.)
- Making Orders.
- Adding Products to Orders.
- Removing an Order from the collection of all current Orders.
- Showing all current Orders.

I was unable to establish persistent data storage because when I added JPL to pom.xml, there were
build errors that I did not understand how to resolve before the deadline.

I was unable to save product prices for the alloted 1 minute limit. As such, there is no system for order confirmation.
