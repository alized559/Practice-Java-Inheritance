import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class Catalog {
  private String name;
  private List<Item> items;

  // this is used to keep track of added item names so that we don't add
  // two items with the same names
  private Set<String> addedNames;

  public Catalog(String name) {
    this.name = name;
    this.items = new ArrayList<Item>();
    this.addedNames = new HashSet<String>();
  }

  // Adds an Item at the end of the list
  public void add(Item item) {
    if (item == null)
      throw new IllegalArgumentException("item can not be null");
    if (this.addedNames.contains(item.getName()))
      throw new IllegalArgumentException("item with name " + item.getName()
        + " already exist");
    this.addedNames.add(item.getName());
    this.items.add(item);
  }

  // the purpose for this method is to create the item order only from catalog
  // and not using new Item(...) in ShoppingCart. In this way, we make sure
  // that the orders are from the created Catalogs only and there are no
  // duplicates
  public ItemOrder createOrder(int index, int quantity) {
    return new ItemOrder(this.get(index), quantity);
  }

  // Returns the size of the list
  public int size() {
    return this.items.size();
  }

  // Returns the Item with the given index
  public Item get(int index) {
    if (index < 0 || index >= this.size())
      throw new IllegalArgumentException("index out of bound. Given: " + index);
    return this.items.get(index);
  }

  // Returns the name of the catalog.
  public String getName() {
    return this.name;
  }

  public String toString() {
    String res = "Catalog Name: " + this.name;
    res += "\nItems:\n";
    res += "------";
    for (Item item: this.items) {
      res += '\n' + item.toString();
    }
    return res;
  }
}
