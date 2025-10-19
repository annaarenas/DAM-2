import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        products.add(new Product("Laptop", "Electronics", 999.99));
        products.add(new Product("Smartphone", "Electronics", 699.99));
        products.add(new Product("Desk Chair", "Furniture", 89.99));
        products.add(new Product("Notebook", "Stationery", 2.49));
        products.add(new Product("Pen", "Stationery", 0.99));
        products.add(new Product("Headphones", "Electronics", 199.99));
        products.add(new Product("Coffee Table", "Furniture", 149.99));
        products.add(new Product("Monitor", "Electronics", 249.99));
        products.add(new Product("Trousers", "Clothing", 32.99));
        products.add(new Product("Jacket", "Clothing", 59.99));

        // Filter products by category "Electronics" and print their names
        List<String> electronicsNames = products.stream().filter(p -> p.getCategory().equals("Electronics"))
                .map(p -> p.getName()).toList();

        System.out.println("Electronics Products: ");
        for(String name : electronicsNames) {
            System.out.println(name);
        }

        System.out.println();

        // Calculate the total price of all products in the "Furniture" category
        double totalPrice = products.stream().filter(p -> p.getCategory().equals("Furniture")).map(p -> p.getPrice()).reduce(0.0, (a,b) -> a + b).doubleValue();
        System.out.println("Total price of Furniture products: " + totalPrice);

        System.out.println();

        // Get a list of unique product categories
        List<String> uniqueCategories = products.stream().map(Product::getCategory).distinct().toList();
        System.out.println("Unique Product Categories: ");

        for(String category : uniqueCategories) {
            System.out.println(category);
        }

        System.out.println();

        // Find the cheapest product in the "Clothing" category
        Product cheapestClothe = products.stream().filter(p -> p.getCategory().equals("Clothing")).sorted((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice())).findFirst().orElse(null);

        System.out.println("Cheapest Clothing Product is: " + cheapestClothe.getName() + " with price " + cheapestClothe.getPrice());

        System.out.println();

        //Group the products by category and print the number of products in each category.
        int amountElectronics = (int) products.stream().filter(p -> p.getCategory().equals("Electronics")).count();
        int amountFurniture = (int) products.stream().filter(p -> p.getCategory().equals("Furniture")).count();
        int amountStationery = (int) products.stream().filter(p -> p.getCategory().equals("Stationery")).count();
        int amountClothing = (int) products.stream().filter(p -> p.getCategory().equals("Clothing")).count();

        System.out.println("Number of products in each category:");
        System.out.println("Electronics: " + amountElectronics);
        System.out.println("Furniture: " + amountFurniture);
        System.out.println("Stationery: " + amountStationery);
        System.out.println("Clothing: " + amountClothing);
    }
}