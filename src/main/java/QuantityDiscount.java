class QuantityDiscount extends BaseDiscount {

    public QuantityDiscount(Discount nextDiscount) {
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
    public String getDescription(Product product) {
        String description = "";
//        return "10 SEK discount when purchases at least 5 products";
//        String description = "10 SEK discount when purchases at least 5 products";
//        return description + super.getDescription(product);
//
        if (isApplicable(product)) {
            description += "10 SEK discount when purchases at least 5 products. ";
        }
        description += super.getDescription(product);
        return description;
    }
}

