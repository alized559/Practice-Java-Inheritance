import java.text.NumberFormat;
import java.util.Locale;

public class Item implements Comparable<Item> {
  private String name; // should be unique. i.e no 2 items should have same name
  private double price;
  private int bulkQuantity;
  private double bulkPrice;

  private static NumberFormat nf = NumberFormat.getCurrencyInstance(
    new Locale("en", "US")); // set local to US to make sure to use $ as currency

  public Item(String name, double price) {
    if (price < 0)
      throw new IllegalArgumentException("price can not be negative");
    this.name = name;
    this.price = price;
    this.bulkQuantity = 1;
    this.bulkPrice = price;
  }

  public Item(String name, double price, int bulkQuantity, double bulkPrice) {
    if (price < 0 || bulkQuantity < 0 || bulkPrice < 0)
      throw new IllegalArgumentException("price can not be negative");
    this.name = name;
    this.price = price;
    this.bulkQuantity = bulkQuantity;
    this.bulkPrice = bulkPrice;
  }

  // Returns the price for a given quantity of the item
  public double priceFor(int quantity, boolean withDiscount) {
    if (withDiscount) {
      int numBulks = quantity / this.bulkQuantity; // number of bulks
      int remItems = quantity % this.bulkQuantity; // remaining items (not in bulks)
      return numBulks * this.bulkPrice + remItems * this.price;
    }
    return quantity * this.price; // no bulk discount
  }

  public String getFormattedPrice(double price) {
    return nf.format(price);
  }

  // Returns the name of the Item
  public String getName() {
    return this.name;
  }

  // This method compare two Items
  public int compareTo(Item other) {
    // we need to lower case the names to have a correct comparison.
    // e.g if we have two items: Chips, and chips they should be treated as
    // the same item
    String thisName = this.name.toLowerCase();
    String otherName = other.name.toLowerCase();
    return thisName.compareTo(otherName); // use String compareTo :)
  }

  public String toString() {
    return "Item(name=" + name + ", price=" + getFormattedPrice(price) +
      ", bulkQuantity=" + bulkQuantity + ", bulkPrice=" +
      getFormattedPrice(bulkPrice) + ")";
  }
}
