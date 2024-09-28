import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GeneralDiscountTest {
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
    void testQuantityDiscountApply() {

        Product product = new Product("apple", 15.00, 10);

        GeneralDiscount quantityDiscount = Main.getQuantityDiscount();
        double discount = quantityDiscount.apply(product);

        assertThat(quantityDiscount).isNotNull();
        assertThat(discount).isEqualTo(10);
    }

    @Test
    void testQuantityDiscountNotApply() {

        Product product = new Product("milk", 15.00, 1);

        GeneralDiscount quantityDiscount = Main.getQuantityDiscount();
        double discount = quantityDiscount.apply(product);

        assertThat(quantityDiscount).isNotNull();
        assertThat(discount).isEqualTo(0.0);
    }
}
