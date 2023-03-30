public class BankAccountTest {
    public static void main(String[] args) {
        testCreateAccount();
        testDeposit();
        testWithdrawMoney();
    }

    private static void testCreateAccount() {
        BankAccount account = BankAccount.createAccount("123456");
        if (!account.getAccountNumber().equals("123456")) {
            System.out.println("testCreateAccount: Failed - account number does not match");
        } else {
            System.out.println("testCreateAccount: Passed");
        }
    }

    private static void testDeposit() {
        BankAccount account = BankAccount.createAccount("123456");
        account.deposit(100);
        if (account.getBalance() != 100) {
            System.out.println("testDeposit: Failed - balance does not match");
        } else {
            System.out.println("testDeposit: Passed");
        }
    }

    private static void testWithdrawMoney() {
        BankAccount sourceAccount = BankAccount.createAccount("123456");
        sourceAccount.deposit(100);

        BankAccount destinationAccount = BankAccount.createAccount("789012");
        Transaction transaction = new Transaction(50, sourceAccount, destinationAccount);

        try {
            sourceAccount.withdrawMoney(transaction);
            if (sourceAccount.getBalance() != 50) {
                System.out.println("testWithdrawMoney: Failed - balance does not match");
            } else {
                System.out.println("testWithdrawMoney: Passed");
            }
        } catch (NotEnoughFundsException e) {
            System.out.println("testWithdrawMoney: Failed - should not have thrown an exception");
        }

        transaction = new Transaction(100, sourceAccount, destinationAccount);

        try {
            sourceAccount.withdrawMoney(transaction);
            System.out.println("testWithdrawMoney: Failed - should have thrown a NotEnoughFundsException");
        } catch (NotEnoughFundsException e) {
            System.out.println("testWithdrawMoney: Passed");
        }
    }
}
