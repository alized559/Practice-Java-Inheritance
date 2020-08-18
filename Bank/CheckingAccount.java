public class CheckingAccount extends Account {
  public double transcationFee;

  public CheckingAccount(double initialBalance, double feeAmount) {
    super(initialBalance);
    this.transcationFee = feeAmount;
  }

  public boolean credit(double amount) {
    if (super.credit(amount)) {
      super.debit(this.transcationFee);
      return true;
    }
    return false;

  }

  public boolean debit(double amount) {
    if (super.debit(amount)) {
      super.debit(this.transcationFee);
      return true;
    }
    return false;
  }
}
