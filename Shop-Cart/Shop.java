public class Shop {
  public static void main(String[] args) {
    Catalog snacks = new Catalog("Snacks");
    snacks.add(new Item("chips", 1, 10, 5));
    snacks.add(new Item("cola", 2, 10, 4));

    ShoppingCart shopCart = new ShoppingCart();
    shopCart.add(snacks.createOrder(0, 10));
    shopCart.add(snacks.createOrder(1, 5));
    shopCart.add(snacks.createOrder(1, 6));
    System.out.println(shopCart);
    //shopCart.setDiscount(false);
    System.out.println("Total price: " + shopCart.getTotal());
  }
}
