import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Object> checkout = new ArrayList<>();

        Product product1 = new Product("light", 24.90, 3);
        Product product2 = new Product("apple", 12.00, 10);
        Product product3 = new Product("milk", 15.00, 10);
        Product product4 = new Product("milk", 15.00, 1);

        checkout.add(product1);
        checkout.add(product2);
        checkout.add(product3);
        checkout.add(product4);

        Discount discountChain = new MilkDiscount((new FridayDiscount(new QuantityDiscount(null))));

        checkout.stream().map(product -> {
                    double totalDiscount = discountChain.apply((Product) product);
                    String description = discountChain.getDescription((Product) product);
                    String productName = ((Product) product).name();
                    return (productName + ": "
                            + String.format("%s %.2f", description, totalDiscount)
                            + " SEK total discount");
                })
                .forEach(System.out::println);
    }
}
