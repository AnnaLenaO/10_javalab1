import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class GeneralDiscountTest {
    private MockedStatic<Main> mockedMain;

    @Test
    void testMilkDiscountApply() {

        Product product = new Product("milk", 15.00, 10);

        GeneralDiscount milkDiscount = Main.getMilkDiscount();
        double discount = milkDiscount.apply(product);

        assertThat(milkDiscount).isNotNull();
        assertThat(discount).isEqualTo(7.5);
    }

    @Test
    void testMilkDiscountNotApply() {

        Product product = new Product("apple", 15.00, 10);

        GeneralDiscount milkDiscount = Main.getMilkDiscount();
        double discount = milkDiscount.apply(product);

        assertThat(milkDiscount).isNotNull();
        assertThat(discount).isEqualTo(0.0);
    }

    @Test
    void testMilkDiscountGetDescription() {

        Product product = new Product("milk", 15.00, 10);

        GeneralDiscount milkDiscount = Main.getMilkDiscount();
        String description = milkDiscount.getDescription(product);

        assertThat(milkDiscount).isNotNull();
        assertThat(description).isEqualTo("Milk Discount 5 %. ");
    }

    @Test
    void testMilkDiscountNotGetDescription() {

        Product product = new Product("apple", 15.00, 10);

        GeneralDiscount milkDiscount = Main.getMilkDiscount();
        String description = milkDiscount.getDescription(product);

        assertThat(milkDiscount).isNotNull();
        assertThat(description).isNotEqualTo("Milk Discount 5 %. ");
        assertThat(description).isEqualTo("");
    }

    @Test
    void testQuantityDiscountApply() {

        Product product = new Product("apple", 15.00, 6);

        GeneralDiscount quantityDiscount = Main.getQuantityDiscount();
        double discount = quantityDiscount.apply(product);

        assertThat(quantityDiscount).isNotNull();
        assertThat(discount).isEqualTo(10);
    }

    @Test
    void testQuantityDiscountNotApply() {

        Product product = new Product("milk", 15.00, 4);

        GeneralDiscount quantityDiscount = Main.getQuantityDiscount();
        double discount = quantityDiscount.apply(product);

        assertThat(quantityDiscount).isNotNull();
        assertThat(discount).isEqualTo(0.0);
    }

    @Test
    void testQuantityDiscountGetDescription() {

        Product product = new Product("apple", 15.00, 6);

        GeneralDiscount quantityDiscount = Main.getQuantityDiscount();
        String description = quantityDiscount.getDescription(product);

        assertThat(quantityDiscount).isNotNull();
        assertThat(description).isEqualTo(
                "Quantity Discount 10 SEK for more than 5 products. ");
    }

    @Test
    void testQuantityDiscountNotGetDescription() {

        Product product = new Product("apple", 15.00, 4);

        GeneralDiscount quantityDiscount = Main.getQuantityDiscount();
        String description = quantityDiscount.getDescription(product);

        assertThat(quantityDiscount).isNotNull();
        assertThat(description).isNotEqualTo(
                "Quantity Discount 10 SEK for more than 5 products. ");
        assertThat(description).isEqualTo("");
    }

    @Test
    void testFridayDiscountApply() {
        Product product = new Product("apple", 15.00, 10);
        GeneralDiscount fridayDiscount = Main.getFridayDiscount();

        try (MockedStatic<Main> mockedMain = mockStatic(Main.class)) {
            mockedMain.when(() -> Main.testFriday(product)).thenReturn(true);
            Double discount = fridayDiscount.apply(product);

            assertThat(fridayDiscount).isNotNull();
            assertThat(discount).isEqualTo(
                    15);
        }
    }
}
