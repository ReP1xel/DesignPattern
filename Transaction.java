class Transaction {
    private double amount;
    private BankAccount sourceAccount;
    private BankAccount destinationAccount;

    public Transaction(double amount, BankAccount sourceAccount, BankAccount destinationAccount) {
        this.amount = amount;
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
    }

    public double getAmount() {
        return amount;
    }

    public BankAccount getSourceAccount() {
        return sourceAccount;
    }

    public BankAccount getDestinationAccount() {
        return destinationAccount;
    }
}