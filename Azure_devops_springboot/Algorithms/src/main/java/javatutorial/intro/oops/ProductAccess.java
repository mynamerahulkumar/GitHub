package javatutorial.intro.oops;

public class ProductAccess {
    private int id;
    public float price;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public static void main(String[] args) {
        ProductAccess productAccess=new ProductAccess();
        productAccess.setId(1);
        productAccess.setPrice(100.0f);
        System.out.println("Product id="+productAccess.getId()+" product price="+productAccess.getPrice());
    }

}
