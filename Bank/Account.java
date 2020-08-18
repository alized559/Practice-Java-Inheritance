public class Account {
  private double accountBalance;
  public long accountNumber;
  static int id = 0;

  public Account(double initialBalance) {
    if (initialBalance >= 0)
      this.accountBalance = initialBalance;
    else
      throw new IllegalArgumentException(initialBalance + " less than 0.0");
    this.accountNumber = id;
    id++;
  }

  public double getBalance() {
    return this.accountBalance;
  }

  public boolean credit(double amount) {
    if (amount >= 0) {
      this.accountBalance += amount;
      return true;
    }
    return false;
  }

  public boolean debit(double amount) {
    if (amount > 0 && amount <= this.accountBalance) {
      this.accountBalance -= amount;
      return true;
    }
    return false;
  }

  public String toString() {
    return this.getClass().getName() + "(balance=" + this.accountBalance
      + ", number=" + this.accountNumber + ")";
  }
}
