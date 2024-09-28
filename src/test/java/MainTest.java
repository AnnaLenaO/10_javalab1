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
}
