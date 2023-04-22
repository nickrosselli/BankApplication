import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Database Connection Info
        String url = "jdbc:mysql://localhost:3306/bankoftuggs";
        String username = "root";
        String password = "coloniE92323!";

        // Loading JDBC driver
        // System.out.println("Loading driver..."); | // This was for testing purposes
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // System.out.println("Driver loaded!"); | // This was for testing purposes
            ;
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Cannot find driver in Classpath!");
        }

        // Database Connection
        // System.out.println("Connecting database..."); | // This was for testing purposes
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // System.out.println("Database connected!");  | // This was for testing purposes
            ;
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }

        int choice;
        do {
            choice = showMenu();
            switch (choice) {
                case 1 -> newAccount();
                case 2 -> balance();
                case 3 -> deposit();
                case 4 -> withdrawal();
                case 5 -> {
                    System.out.println("Thank you for choosing Bank of Tuggs. Goodbye!");
                    return;
                }
                default -> {
                    System.out.println("Please enter a valid option...");
                    showMenu();
                }
            }
        } while (true);


    }


    public static int showMenu() {
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Bank of Tuggs!");
        System.out.println("-------------------------");
        System.out.println("1) Open an account");
        System.out.println("2) View your balance");
        System.out.println("3) Make a deposit");
        System.out.println("4) Withdraw funds");
        System.out.println("5) Exit");
        System.out.println("-------------------------");
        System.out.println("Select an option: ");

        try {
            choice = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("You must enter a number. Try again!");
        }


        return choice;
    }

    private static void newAccount() {
        System.out.println("YOU PICKED OP1!!!");
    }

    private static void balance() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your customer ID: ");
        int customerId = scanner.nextInt();



    }

    private static void deposit() {
    }

    private static void withdrawal() {
    }
}


