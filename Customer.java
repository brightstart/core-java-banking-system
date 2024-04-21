import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

class Customer{
    private String customerId;
    private String name;
    private List<Account> accounts;
    public Customer(String customerId, String name, Account cust_account) {
        this.customerId = customerId;
        this.name = name;
        this.accounts = new ArrayList<Account>();
    }
    public String getCustomerid() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }
    public void addAccount(Account account) {
        accounts.add(account);
    }

    public Account getAccountFromAccountNumber(String accountNumber){
        Optional<Account> optionalAccount = accounts.stream()
                                                    .filter(account -> account.getAccountNumber()
                                                    .equals(accountNumber)).findFirst();
        return optionalAccount.orElse(null);
                                                    
    }

    public void removeAccount(String accountNumber){
        Account accountToBeRemoved = getAccountFromAccountNumber(accountNumber);
        if (accountToBeRemoved != null)
        {
            accounts.remove(accountToBeRemoved);
        }
    }

    public void removeAccount(Account account){
        accounts.remove(account);
    }

    public int getTotalTransactionCount() {
        return accounts.stream()
                      .mapToInt(Account::getTransactionCount)
                      .sum();
    }

    public static List<Customer> rankCustomers ( List<Customer> customers){
        return customers.stream().sorted(Comparator.comparingInt(Customer::getTotalTransactionCount)).toList();
    }

    public static Customer getCustomerFromAccount(Account account, List<Customer> allCustomers){

        Optional<Customer> optionalCustomer = allCustomers.stream()
                                        .filter(customer -> customer.getAccounts().contains(account))
                                        .findFirst();
        

        return optionalCustomer.orElse(null);

    }

}