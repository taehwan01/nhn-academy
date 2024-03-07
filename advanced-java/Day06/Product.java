public class Product {
    protected int productNo;
    protected String productName;

    public Product(int productNo, String productName) {
        this.productNo = productNo;
        this.productName = productName;
    }

    public int getProductNo() {
        return this.productNo;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductNo(int productNo) {
        this.productNo = productNo;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
