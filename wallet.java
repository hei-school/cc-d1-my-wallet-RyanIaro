import java.util.Scanner;

public class wallet {
    private static double balance = 0;

    public static void checkBalance() {
        if (balance != 0) {
            System.out.println("Your current balance is: " + balance +"$");
        } else {
            System.out.println("lmao you broke.");
        }
        showMenu();
    }

    public static void deposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How much money to deposit? ");
        if (scanner.hasNextDouble()) {
            double amount = scanner.nextDouble();
            if (amount > 0) {
                balance += amount;
                System.out.println("You deposit " + amount + "$. Your new balance is: " + balance +"$");
            } else {
                System.out.println("Invalid amount. Please enter a positive number.");
            }
        } else {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.next();
        }
        showMenu();
    }

    public static void withdraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How much money to withdraw? ");
        if (scanner.hasNextDouble()) {
            double amount = scanner.nextDouble();
            if (amount > 0) {
                if (amount <= balance) {
                    balance -= amount;
                    System.out.println("You withdraw " + amount + "$. Your new balance is: " + balance +"$");
                } else {
                    System.out.println("You too poor for that.");
                }
            } else {
                System.out.println("Invalid amount. Please enter a positive number.");
            }
        } else {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.next();
        }
        showMenu();
    }

    public static void putInPocket() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nThe wallet is in your pocket. What to do now?");
        System.out.println("1. Take it out");
        System.out.println("2. Leave it alone");
        System.out.println("3. Yeet!");
        System.out.println(": ");
        
        if (scanner.hasNextInt()) {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("You decide to free the wallet from your pocket.");
                    showMenu();
                    break;
                case 2:
                    System.out.println("You decide to leave it alone for now.");
                    putInPocket();
                    break;
                    case 3:
                    yeet();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 3.");
                    putInPocket();
                    break;
            }
        } else {
            System.out.println("Invalid input. Please enter a valid number.");
            putInPocket();
        }
    }

    public static void yeet() {
        System.out.println("You throw the wallet and never see it again, nor get the money inside it back.");
        System.exit(0);
    }

    public static void showMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nThis is your wallet, what do you want to do?(choose a number)");
        System.out.println("1. Check your balance");
        System.out.println("2. Deposit some money");
        System.out.println("3. Withdraw some money");
        System.out.println("4. Put in your pocket");
        System.out.println("5. Throw and buy a new one later (you lose your money)");

        System.out.print(": ");

        if (scanner.hasNextInt()) {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    putInPocket();
                    break;
                case 5:
                    yeet();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                    showMenu();
                    break;
            }
        } else {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.next();
            showMenu();
        }
    }

    public static void main(String[] args) {
        showMenu();
    }
}
