package ar.edu.utnfc.backend;

import ar.edu.utnfc.backend.Entities.Empleado;
import java.util.ArrayList;
import java.util.Scanner;
public class App {
    public static void main( String[] args ) {
        ReadData readDataInstance = new ReadData();
        ArrayList<Empleado> empleados = readDataInstance.readData();

        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Option input:");
        String option = scanner.nextLine();
        switch (option) {
            case "1":
                // Handle option 1
                break;
            case "2":
                // Handle option 2
                break;      
            case "3":
                // Handle option 3
                break;
            case "4":
                // Handle option 4
                break;
            case "close": 
                // Handle option 5
                System.out.println("Closing the application.");
                break;  
            default:
                System.out.println("Invalid option. Please try again.");
                break;
        }
    }
}