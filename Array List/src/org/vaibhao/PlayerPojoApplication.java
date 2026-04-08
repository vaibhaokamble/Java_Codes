package org.vaibhao;

import java.util.ArrayList;
import java.util.Scanner;

class Player {
    private int id;
    private String name;
    private int run;

    // Constructor
    public Player(int id, String name, int run) {
        this.id = id;
        this.name = name;
        this.run = run;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getRun() {
        return run;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\tName: " + name + "\tRuns: " + run;
    }
}

public class PlayerPojoApplication {
    public static void main(String[] args) {
        ArrayList<Player> players = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n===== Player Management System =====");
            System.out.println("1. Add New Player");
            System.out.println("2. Display All Players");
            System.out.println("3. Delete Player by ID");
            System.out.println("4. Search Player by ID");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            
            int choice;
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // clear the buffer
                continue;
            }
            
            switch (choice) {
                case 1:
                    addPlayer(players, scanner);
                    break;
                case 2:
                    displayAllPlayers(players);
                    break;
                case 3:
                    deletePlayer(players, scanner);
                    break;
                case 4:
                    searchPlayer(players, scanner);
                    break;
                case 5:
                    System.out.println("Exiting the application. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1-5.");
            }
        }
    }
    
    private static void addPlayer(ArrayList<Player> players, Scanner scanner) {
        System.out.println("\n--- Add New Player ---");
        
        try {
            System.out.print("Enter Player ID: ");
            int id = scanner.nextInt();
            
            // Check if ID already exists
            for (Player p : players) {
                if (p.getId() == id) {
                    System.out.println("Player with this ID already exists!");
                    return;
                }
            }
            
            scanner.nextLine(); // consume newline
            System.out.print("Enter Player Name: ");
            String name = scanner.nextLine();
            
            System.out.print("Enter Player Runs: ");
            int run = scanner.nextInt();
            
            players.add(new Player(id, name, run));
            System.out.println("Player added successfully!");
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter correct data types.");
            scanner.nextLine(); // clear the buffer
        }
    }
    
    private static void displayAllPlayers(ArrayList<Player> players) {
        System.out.println("\n--- All Players ---");
        if (players.isEmpty()) {
            System.out.println("No players found in the system.");
            return;
        }
        
        for (Player p : players) {
            System.out.println(p);
        }
    }
    
    private static void deletePlayer(ArrayList<Player> players, Scanner scanner) {
        System.out.println("\n--- Delete Player ---");
        System.out.print("Enter Player ID to delete: ");
        
        try {
            int id = scanner.nextInt();
            boolean removed = players.removeIf(p -> p.getId() == id);
            
            if (removed) {
                System.out.println("Player deleted successfully!");
            } else {
                System.out.println("Player not found with ID: " + id);
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine(); // clear the buffer
        }
    }
    
    private static void searchPlayer(ArrayList<Player> players, Scanner scanner) {
        System.out.println("\n--- Search Player ---");
        System.out.print("Enter Player ID to search: ");
        
        try {
            int id = scanner.nextInt();
            boolean found = false;
            
            for (Player p : players) {
                if (p.getId() == id) {
                    System.out.println("Player found:");
                    System.out.println(p);
                    found = true;
                    break;
                }
            }
            
            if (!found) {
                System.out.println("Player not found with ID: " + id);
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine(); // clear the buffer
        }
    }
}