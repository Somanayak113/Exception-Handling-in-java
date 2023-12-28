//Exception handling in bank with multiple try catch block
package com.code;
import java.util.Scanner;

public class BankingExceptionHandling 
{

	// Initial balance
    private static double balance = 5000; 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            while (true) {
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Check Balance");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        deposit();
                        break;
                    case 2:
                        withdraw();
                        break;
                    case 3:
                        checkBalance();
                        break;
                    case 4:
                        System.out.println("Exiting the program. Thank you!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    private static void deposit() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the amount to deposit: ");
            double amount = scanner.nextDouble();
            if (amount <= 0) {
                throw new IllegalArgumentException("Deposit amount must be greater than zero.");
            }
            balance += amount;
            System.out.println("Deposit successful. Current balance: " + balance);
        } catch (Exception e) {
            System.out.println("Error during deposit: " + e.getMessage());
        }
    }

    private static void withdraw() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the amount to withdraw: ");
            double amount = scanner.nextDouble();
            if (amount <= 0) {
                throw new IllegalArgumentException("Withdrawal amount must be greater than zero.");
            }
            if (amount > balance) {
                throw new IllegalStateException("Insufficient funds. Current balance: " + balance);
            }
            balance -= amount;
            System.out.println("Withdrawal successful. Current balance: " + balance);
        } catch (Exception e) {
            System.out.println("Error during withdrawal: " + e.getMessage());
        }
    }

    private static void checkBalance() {
        System.out.println("Current balance: " + balance);
    }
}