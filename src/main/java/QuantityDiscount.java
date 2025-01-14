class QuantityDiscount extends BaseDiscount {

    protected QuantityDiscount(Discount nextDiscount) {
        super(nextDiscount);
    }

    @Override
    protected boolean isApplicable(Product product) {
        return product.quantity() >= 5;
    }

    @Override
    protected double calculateDiscount(Product product) {
        return 10;
    }

    @Override
    protected String description(Product product) {
        return "Quantity Discount 10 SEK for more than 5 products. ";
    }
}
