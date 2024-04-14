package oasis;

import java.util.Scanner;
class LoginForm {
    private String username;
    private String password;
    
    public LoginForm(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public boolean validateLogin(String inputUsername, String inputPassword) {
        return inputUsername.equals(username) && inputPassword.equals(password);
    }
}
class ReservationSystem {
    public void fillReservationForm(String trainNumber, String trainName, String classType, String dateOfJourney, String from, String to) {
        // Logic to fill reservation form
        System.out.println("Reservation form filled successfully!");
    }
}
class CancellationForm {
    public void cancelTicket(String pnrNumber) {
        // Logic to cancel ticket
        System.out.println("Ticket with PNR " + pnrNumber + " cancelled successfully!");
    }
}

public class online_reserve {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
     
        String username = "admin";
        String password = "password";
        
        LoginForm loginForm = new LoginForm(username, password);
        ReservationSystem reservationSystem = new ReservationSystem();
        CancellationForm cancellationForm = new CancellationForm();
        
        // Login
        System.out.println("Welcome to Online Reservation System");
        System.out.print("Enter username: ");
        String inputUsername = scanner.nextLine();
        System.out.print("Enter password: ");
        String inputPassword = scanner.nextLine();
        
        if (loginForm.validateLogin(inputUsername, inputPassword)) {
            System.out.println("Login successful!");
            
           
            System.out.println("\nMenu:");
            System.out.println("1. Fill Reservation Form");
            System.out.println("2. Cancel Ticket");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            
            scanner.nextLine(); 
            
            switch (choice) {
                case 1:
                    
                    System.out.print("Enter train number: ");
                    String trainNumber = scanner.nextLine();
                    System.out.print("Enter train name: ");
                    String trainName = scanner.nextLine();
                    System.out.print("Enter class type: ");
                    String classType = scanner.nextLine();
                    System.out.print("Enter date of journey: ");
                    String dateOfJourney = scanner.nextLine();
                    System.out.print("Enter from (place): ");
                    String from = scanner.nextLine();
                    System.out.print("Enter destination: ");
                    String to = scanner.nextLine();
                    
                    reservationSystem.fillReservationForm(trainNumber, trainName, classType, dateOfJourney, from, to);
                    break;
                    
                case 2:
                    System.out.print("Enter PNR number: ");
                    String pnrNumber = scanner.nextLine();
                    cancellationForm.cancelTicket(pnrNumber);
                    break;
                    
                default:
                    System.out.println("Invalid choice!");
            }
        } else {
            System.out.println("Invalid username or password!");
        }
        
        scanner.close();
    }
}


