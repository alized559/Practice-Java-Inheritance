public class SavingsAccount extends Account {
  public double rate;

  public SavingsAccount(double initialBalance, double initialValue) {
    super(initialBalance);
    this.rate = initialValue;
  }

  public double calculateInterest() {
    return super.getBalance() * this.rate;
  }
}
