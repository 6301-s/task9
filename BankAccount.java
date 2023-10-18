class BankAccount {
    protected double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: rupees" + amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: rupees" + amount);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance");
        }

        System.out.println("Current balance: rupees" + balance);
    }
}


class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(double initialBalance, double interestRate) {
        super(initialBalance);
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        double interest = balance * interestRate;
        balance += interest;
        System.out.println("Interest applied: rupees" + interest);
        System.out.println("Current balance: rupees" + balance);
    }
}


class CheckingAccount extends BankAccount {
    private double overdraftLimit;

    public CheckingAccount(double initialBalance, double overdraftLimit) {
        super(initialBalance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && (balance + overdraftLimit) >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: rupees" + amount);
        } else {
            System.out.println("Invalid withdrawal amount or overdraft limit exceeded");
        }

        System.out.println("Current balance: rupees" + balance);
    }
}

public class Main {
    public static void main(String[] args) {
        
        SavingsAccount savingsAccount = new SavingsAccount(1000, 0.05);

        
        CheckingAccount checkingAccount = new CheckingAccount(500, 200);

        
        savingsAccount.deposit(200);
        savingsAccount.applyInterest();
        savingsAccount.withdraw(100);

        checkingAccount.deposit(100);
        checkingAccount.withdraw(700); 
    }
}
