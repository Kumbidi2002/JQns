import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// BankACC class to represent individual bank accounts
class BankACC {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    // Constructor
    public BankACC(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    // Override toString() method for easy display
    @Override
    public String toString() {
        return "Account Number: " + accountNumber + ", Account Holder: " + accountHolderName + ", Balance: $" + balance;
    }
}

// Bank class to represent the bank
class Bank {
    private String name;
    private List<BankACC> accounts;

    // Constructor
    public Bank(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    // Method to add a new bank account
    public void addAccount(BankACC account) {
        accounts.add(account);
    }

    // Method to find an account by account number
    public BankACC findAccountByNumber(String accountNumber) {
        for (BankACC account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    // Method to display all accounts in the bank
    public void displayAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts in the bank.");
        } else {
            for (BankACC account : accounts) {
                System.out.println(account);
            }
        }
    }

    // Main method to test the Bank class
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank("Global Bank");

        while (true) {
            System.out.println("Bank Menu:");
            System.out.println("1. Add a new account");
            System.out.println("2. Find an account by account number");
            System.out.println("3. Display all accounts");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the account number: ");
                    String accountNumber = scanner.nextLine();
                    System.out.print("Enter the account holder's name: ");
                    String accountHolderName = scanner.nextLine();
                    System.out.print("Enter the initial balance: ");
                    double balance = scanner.nextDouble();
                    bank.addAccount(new BankACC(accountNumber, accountHolderName, balance));
                    break;
                case 2:
                    System.out.print("Enter the account number to search: ");
                    String searchAccountNumber = scanner.nextLine();
                    BankACC account = bank.findAccountByNumber(searchAccountNumber);
                    if (account != null) {
                        System.out.println(account);
                    } else {
                        System.out.println("No account found with the account number: " + searchAccountNumber);
                    }
                    break;
                case 3:
                    bank.displayAllAccounts();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
