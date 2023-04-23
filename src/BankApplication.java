import java.util.Scanner;

public class BankApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Bank! Enter your name and account number to access your bank account.\n");

        System.out.println("Name: ");
        String name = scanner.nextLine();

        System.out.println("Account Number: ");
        String accNum = scanner.nextLine();

        BankAccount obj = new BankAccount(name, accNum);
        obj.menu();

    }
}

class BankAccount {
    double balance;
    String customerName;
    String accountNumber;

    BankAccount(String customerName, String accountNumber) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
    }

    void deposit(double amount) {
        if (amount != 0) {
            balance += amount;
        }
    }

    void withdrawal(double amount) {
        if (amount != 0 && balance > amount) {
            balance -= amount;
        } else if (balance < amount) {
            System.out.println("Insufficient Funds. Please contact support!");
        }
    }

    void menu() {
        int choice;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome, " + customerName + "!");
        System.out.println("-------------------------");
        System.out.println("1) View your balance");
        System.out.println("2) Make a deposit");
        System.out.println("3) Withdraw funds");
        System.out.println("4) Exit");

        do {
            System.out.println("-------------------------");
            System.out.println("Choose an option: ");
            choice = scanner.nextInt();
            System.out.println("\n");

            switch (choice) {
                case 1 -> {
                    System.out.println("-------------------");
                    System.out.println("Balance: $" + balance);
                    System.out.println("-------------------");
                }
                case 2 -> {
                    System.out.println("-------------------");
                    System.out.println("Enter your deposit amount: ");
                    double amount = scanner.nextDouble();
                    deposit(amount);
                    System.out.println("\n");
                }
                case 3 -> {
                    System.out.println("-------------------");
                    System.out.println("Enter your withdrawal amount: ");
                    double amt = scanner.nextDouble();
                    withdrawal(amt);
                    System.out.println("\n");
                }
                case 4 -> {
                    System.out.println("-------------------");
                    System.out.println("Thank you, goodbye!");
                }
                default ->
                        throw new IllegalStateException(choice + "is not a valid option. Please select from the list provided!");
            }

        } while (choice != 4);


    }
}


