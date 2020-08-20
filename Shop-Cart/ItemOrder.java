public class ItemOrder {
  private Item item;
  private int quantity;

  public ItemOrder(Item item, int quantity) {
    this.item = item;
    this.quantity = quantity;
  }

  // Returns the cost for the item order
  public double getPrice(boolean withDiscount) {
    return this.item.priceFor(this.quantity, withDiscount);
  }

  // Returns a reference to the item in this order
  public Item getItem() {
    return this.item;
  }

  public String toString() {
    String res = "ItemOrder(\n";
    res += "  ";
    res += this.item;
    res += "\n  ";
    res += "quantity=" + quantity;
    res += "\n)";
    return res;
  }
}
