package oasis;

import java.util.Scanner;
class Transaction {
 private String type;
 private double amount;

 public Transaction(String type, double amount) {
     this.type = type;
     this.amount = amount;
 }

 @Override
 public String toString() {
     return type + ": $" + amount;
 }
}
class Account {
 private double balance;
 private Transaction[] transactions;
 private int transactionCount;

 public Account() {
     balance = 0.0;
     transactions = new Transaction[100];
     transactionCount = 0;
 }

 public double getBalance() {
     return balance;
 }

 public void deposit(double amount) {
     balance += amount;
     addTransaction("Deposit", amount);
 }

 public boolean withdraw(double amount) {
     if (balance >= amount) {
         balance -= amount;
         addTransaction("Withdraw", amount);
         return true;
     } else {
         System.out.println("Insufficient funds!");
         return false;
     }
 }

 public void transfer(double amount, Account recipient) {
     if (withdraw(amount)) {
         recipient.deposit(amount);
         addTransaction("Transfer to " + recipient.getClass().getSimpleName(), amount);
     }
 }

 private void addTransaction(String type, double amount) {
     transactions[transactionCount++] = new Transaction(type, amount);
 }

 public void displayTransactionHistory() {
     System.out.println("Transaction History:");
     for (int i = 0; i < transactionCount; i++) {
         System.out.println(transactions[i]);
     }
 }
}


class ATM {
 private Account account;
 private Scanner scanner;

 public ATM(Account account) {
     this.account = account;
     scanner = new Scanner(System.in);
 }

 public void start() {
     System.out.println("Welcome to the ATM!");
     System.out.print("Enter user id: ");
     String userId = scanner.nextLine();
     System.out.print("Enter user pin: ");
     String userPin = scanner.nextLine();

     if (authenticate(userId, userPin)) {
         showMenu();
     } else {
         System.out.println("Invalid user id or pin!");
     }
 }

 private boolean authenticate(String userId, String userPin) {
    
     return userId.equals("sandhya") && userPin.equals("1234");
 }

 private void showMenu() {
     boolean quit = false;
     while (!quit) {
         System.out.println("\nATM Menu:");
         System.out.println("1. View Balance");
         System.out.println("2. Deposit");
         System.out.println("3. Withdraw");
         System.out.println("4. Transfer");
         System.out.println("5. Transaction History");
         System.out.println("6. Quit");
         System.out.print("Enter your choice: ");
         int choice = scanner.nextInt();
         scanner.nextLine(); // Consume newline

         switch (choice) {
             case 1:
                 System.out.println("Your balance: $" + account.getBalance());
                 break;
             case 2:
                 System.out.print("Enter deposit amount: $");
                 double depositAmount = scanner.nextDouble();
                 account.deposit(depositAmount);
                 break;
             case 3:
                 System.out.print("Enter withdrawal amount: $");
                 double withdrawalAmount = scanner.nextDouble();
                 account.withdraw(withdrawalAmount);
                 break;
             case 4:
                 System.out.print("Enter transfer amount: $");
                 double transferAmount = scanner.nextDouble();
                 Account recipient = new Account(); // Simulating transfer to another account
                 account.transfer(transferAmount, recipient);
                 break;
             case 5:
                 account.displayTransactionHistory();
                 break;
             case 6:
                 quit = true;
                 break;
             default:
                 System.out.println("Invalid choice!");
         }
     }
 }
}

public class ATM_interface {
 public static void main(String[] args) {
     Account account = new Account();
     ATM atm = new ATM(account);
     atm.start();
 }
}



