import java.util.ArrayList;
import java.util.List;

class Account{
    private String accountNumber;
    private double balance;
    private int transactionCount;
    private List<Transfer> transferHistory;
    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.transactionCount = 0;
        this.transferHistory = new ArrayList<>() ;
    }
    public int getTransactionCount() {
        return transactionCount;
    }
    public void updateTransactionCountByOne(){
        transactionCount = transactionCount + 1;
    }
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount){
        if(balance < amount)
        {
            System.out.println(accountNumber + " does not have enough balance");
            return;
        }
        balance = balance - amount;
        updateTransactionCountByOne();
        Transfer transfer = new Transfer("WITHDRAWAL", this, null, amount);
        transfer.setStatus(TransferStatus.COMPLETED);
        transferHistory.add(transfer);
        System.out.println("Transaction count : " + transactionCount);
        System.out.println("Amount Withdrawn : " + amount + ", new Balance : " + balance);
    }

    public void deposit(double amount){
        balance = balance + amount;
        updateTransactionCountByOne();
        Transfer transfer = new Transfer("DEPOSIT", null, this, amount);
        transfer.setStatus(TransferStatus.COMPLETED);
        transferHistory.add(transfer);
        System.out.println("Transaction count : " + transactionCount);
        System.out.println("Amount Deposited : " + amount + ", new Balance : " + balance);
    }

    public void addTransfer(Transfer transfer) {
        transferHistory.add(transfer);
    }

    public List<Transfer> getTransferHistory() {
        return transferHistory;
    }

    public void merge(Account accountToMerge){
        double transferAmount = accountToMerge.getBalance();
        this.deposit(transferAmount);
        accountToMerge.withdraw(transferAmount);

        List<Transfer> transferHistoryToMerge = accountToMerge.getTransferHistory();
        for( Transfer transfer : transferHistoryToMerge){
            this.addTransfer(transfer);
        }

        accountToMerge.closeAccount();

        Customer customer = Customer.getCustomerFromAccount(accountToMerge, null);
        customer.removeAccount(accountToMerge);

    }
    private void closeAccount() {
        
    }

}