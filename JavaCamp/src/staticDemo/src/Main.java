public class Main {
    public static void main(String[] args) {
    ProductManager productManager = new ProductManager();
    Product product = new Product();
    product.name = "Mause";
    product.id = 1;
    product.price = 30;

    productManager.add(product);
    }
}
