import java.time.DayOfWeek;
import java.time.LocalDate;
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

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Discount discountChain = new MilkDiscount(new FridayDiscount(new QuantityDiscount(new InnerDiscount())));

        checkout.stream().map(product -> {
                    double totalDiscount = discountChain.apply((Product) product);
                    String description = discountChain.getDescription((Product) product);
                    String productName = ((Product) product).name();
                    return (productName + ": "
                            + String.format("%s %.2f", description, totalDiscount)
                            + " SEK total discount");
                })
                .forEach(System.out::println);

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        final GeneralDiscount milkDiscount = getMilkDiscount();

        final GeneralDiscount fridayDiscount = getFridayDiscount();

        final GeneralDiscount quantityDiscount = getQuantityDiscount();

        checkout.stream().map(product -> {
                    double totalDiscount = -milkDiscount.apply((Product) product)
                            - fridayDiscount.apply((Product) product)
                            - quantityDiscount.apply((Product) product);
                    String totalDescription = milkDiscount.getDescription((Product) product)
                            + fridayDiscount.getDescription((Product) product)
                            + quantityDiscount.getDescription((Product) product);
                    String productName = ((Product) product).name();
                    return (productName + ": "
                            + String.format("%s %.2f", totalDescription, totalDiscount)
                            + " SEK total discount");
                })
                .forEach(System.out::println);
    }

    private static GeneralDiscount getQuantityDiscount() {
        return new GeneralDiscount(
                product -> product.quantity() > 5,
                Main::applyQuantityFixedDiscount,
                Main::applyQuantityDescription
        );
    }

    private static GeneralDiscount getFridayDiscount() {
        return new GeneralDiscount(
                Main::testFriday,
                product -> product.price() * product.quantity() * 0.1,
                Main::applyFridayDescription
        );
    }

    protected static GeneralDiscount getMilkDiscount() {
        return new GeneralDiscount(
                product -> product.name().equals("milk"),
                product -> product.price() * product.quantity() * 0.05,
                Main::applyMilkDescription
        );
    }

    private static String applyMilkDescription(Product product) {
        return "Milk Discount 5 %. ";
    }

    private static String applyFridayDescription(Product product) {
        return "Friday Discount 10 %. ";
    }

    private static String applyQuantityDescription(Product product) {
        return "Quantity Discount 10 SEK for more than 5 products. ";
    }

    private static boolean testFriday(Product product) {
        return LocalDate.now().getDayOfWeek().equals(DayOfWeek.FRIDAY);
    }

    private static Double applyQuantityFixedDiscount(Product product) {
        return 10.0;
    }
}
