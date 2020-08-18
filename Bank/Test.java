public class Test extends CheckingAccount {

  public Test(double initialBalance, double feeAmount) {
    super(initialBalance, feeAmount);
  }

  public static void main(String[] args) {
    Account acc = new Account(10.0);
    acc.credit(2.0);
    acc.debit(5.0);
    System.out.println(acc);

    SavingsAccount savAcc = new SavingsAccount(20.0, 0.1);
    System.out.println("interest = " + savAcc.calculateInterest());
    savAcc.credit(10);
    System.out.println("interest = " + savAcc.calculateInterest());
    savAcc.debit(5);
    System.out.println("interest = " + savAcc.calculateInterest());
    System.out.println(savAcc);

    CheckingAccount checkAcc = new CheckingAccount(100.0, 3.0);
    checkAcc.debit(50.0);
    System.out.println(checkAcc);
  }
}
