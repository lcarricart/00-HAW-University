package setSlides02;

/* BankAccount.java */
public class BankAccount {

    // shared by every account object
    private static double annualInterestRate = 0.02; // 2%. Shared (static) variable with all objects. Its the same variable being reused
    private double balance;                          

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    /* ----------- behaviour that needs the shared rate ----------- */
    public double yearlyInterest() {
        return balance * annualInterestRate;
    }

    /* ----------- controlled access to the static variable ----------- */
    public static void setAnnualInterestRate(double newRate) {
        if (newRate >= 0) {
            annualInterestRate = newRate;
        }
    }

    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    /* ----------- object-specific behaviour ----------- */
    public double getBalance() { return balance; }
    public void deposit(double amount) { balance += amount; }
}

