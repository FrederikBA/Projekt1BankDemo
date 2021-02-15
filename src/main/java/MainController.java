public class MainController {
    public void runProgram() {
        Customer c1 = new Customer("John");
        Account account = new Account(c1);
        try {
            account.depositAmount(500);
            account.depositAmount(400);
        } catch (BankException e) {
            e.printStackTrace();
        }
        try {
            account.withdrawAmount(200);
        } catch (BankException e) {
            e.printStackTrace();
        }

        System.out.println("Available funds: " +account.getBalance());
        account.showAllTransactions();
    }
}
