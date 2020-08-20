import java.util.List;
import java.util.ArrayList;
import java.text.NumberFormat;
import java.util.Locale;

public class ShoppingCart {
  private List<ItemOrder> orders;
  private boolean withDiscount;

  private static NumberFormat nf = NumberFormat.getCurrencyInstance(
    new Locale("en", "US")); // set local to US to make sure to use $ as currency

  public ShoppingCart() {
    this.orders = new ArrayList<ItemOrder>();
    this.setDiscount(true); // by default there is discount
  }

  // This method adds an item order to the list, replacing any previous order
  // for this item with the new order
  public void add(ItemOrder order) {
    // first check if order exists
    for (ItemOrder currOrder: this.orders) {
      // compareTo is already implemented. it just compare names
      if (currOrder.getItem() == order.getItem()) {
        this.orders.remove(currOrder);
        break;
      }
    }
    this.orders.add(order); // old one would be removed if it exists
  }

  // This method sets whether or not this order gets a discount (true means
  // there is adiscount, false means no discount)
  public void setDiscount(boolean value) {
    this.withDiscount = value;
  }

  // Returns the total cost of the shopping cart
  public String getTotal() {
    double totalPrice = 0.0;
    for (ItemOrder order: this.orders) {
      totalPrice += order.getPrice(this.withDiscount);
    }
    return nf.format(totalPrice);
  }

  public String toString() {
    String res = "Orders:";
    for (ItemOrder order: this.orders)
      res += "\n" + order;
    return res;
  }
}
