package javatutorial.intro.oops;

public class Product {
    String name;
    int price;
    public Product(String name){
        this.name=name;//constructor with Parameter
    }
    public int getPrice() {
        System.out.println("Product price is "+price+"$");
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public static void main(String[] args) {
        //Object creation
        Product product=new Product("camera");
        // call class method to set product price
        product.setPrice(600);
        //You can access the instance variable
        System.out.println("Product Name is "+product.name);
    }



}
