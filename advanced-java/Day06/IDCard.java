public class IDCard extends Product {
    public IDCard(int productNo, String productName) {
        super(productNo, productName);
    }

    @Override
    public String getProductName() {
        return "카드: " + this.productName;
    }

    public void getInfo() {
        System.out.println(this.productNo + ", " + this.productName);
    }
}
