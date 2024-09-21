public record Product(String name, double price, int quantity) implements Discount {
    @Override
    public double apply(Product product) {
        return price * quantity;
    }

    @Override
    public String getDescription(Product product) {
        return name;
    }
}
