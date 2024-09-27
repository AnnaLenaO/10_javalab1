class InnerDiscount extends BaseDiscount {
    private static InnerDiscount nextDiscount;

    protected InnerDiscount() {
        super(nextDiscount);
    }

    @Override
    protected boolean isApplicable(Product product) {
        return false;
    }

    @Override
    protected double calculateDiscount(Product product) {
        return 0;
    }

    @Override
    protected String description(Product product) {
        return "";
    }
}
