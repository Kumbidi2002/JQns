import java.util.Scanner;

// BankACC class to represent individual bank accounts
class BankACC{
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
    private BankACC[] accounts;
    private int accountCount;

    // Constructor
    public Bank(String name, int maxAccounts) {
        this.name = name;
        this.accounts = new BankACC[maxAccounts];
        this.accountCount = 0;
    }

    // Method to add a new bank account
    public void addAccount(BankACC account) {
        if (accountCount < accounts.length) {
            accounts[accountCount++] = account;
        } else {
            System.out.println("Cannot add more accounts. Bank is full.");
        }
    }

    // Method to find an account by account number
    public BankACC findAccountByNumber(String accountNumber) {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getAccountNumber().equals(accountNumber)) {
                return accounts[i];
            }
        }
        return null;
    }

    // Method to display all accounts in the bank
    public void displayAllAccounts() {
        if (accountCount == 0) {
            System.out.println("No accounts in the bank.");
        } else {
            for (int i = 0; i < accountCount; i++) {
                System.out.println(accounts[i]);
            }
        }
    }

    // Main method to test the Bank class
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank("Global Bank", 100);  // Adjust the maxAccounts as needed

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
