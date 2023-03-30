import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private String accountNumber;
    private double balance;
    private List<Transaction> transactions;

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
        if (getBalance() < transaction.getAmount()) {
            throw new NotEnoughFundsException("Account does not have enough funds");
        }
        balance -= transaction.getAmount();
        addTransaction(transaction);
    }

    private void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public static BankAccount createAccount(String accountNumber) {
        return new BankAccount(accountNumber);
    }
}