import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private String accountNumber;
    private double balance;
    private List<Transaction> transactions;
    // Remove Setting Method
    private BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0;
        this.transactions = new ArrayList<>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdrawMoney(Transaction transaction) throws NotEnoughFundsException {
        //Replace Parameter with Method Call
        if (getBalance() < transaction.getAmount()) {
            //Separate Query from Modifier
            throw new NotEnoughFundsException("Account does not have enough funds");
        }
        balance -= transaction.getAmount();
        addTransaction(transaction);
    }
    // Hide Method
    private void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }
    // Replace Constructor with Factory Method
    public static BankAccount createAccount(String accountNumber) {
        return new BankAccount(accountNumber);
    }
}