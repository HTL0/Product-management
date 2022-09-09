public class Product {
    private String bcode;
    private String title;
    private Integer quantity;
    private double price;

    public String getBcode() {
        return this.bcode;
    }

    public void setBcode(String bcode) {
        this.bcode = bcode;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    /**
     * Default contructor
     */
    public Product(){}

    /**
     * Contructor
     * @param bcode
     * @param title
     * @param quantity
     * @param price
     */
    public Product(String bcode, String title, Integer quantity, double price){
        this.bcode = bcode;
        this.title = title;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return (Display.formatString(this.getBcode(), Display.IDLENGTH)  + "|" + Display.formatString(this.getTitle(), Display.TITLELENGTH)  + "|" + Display.formatString(String.valueOf(this.getQuantity()), Display.QUANTITYLENGTH)  + "|" + Display.formatString(String.valueOf(this.getPrice()), Display.PRICELENGTH));
    }

}
