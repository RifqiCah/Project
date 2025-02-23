package Main;
import java.util.*;

import Battle.Player;

import java.io.*;

public class Pokemon {
    public static void main(String[] args) {
        Player player = new Player();
        Scanner scanner = new Scanner(System.in);

        // Example usage of scanner
        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();
        System.out.println("Hello, " + playerName + "! Welcome to the game.");

        // Example game loop
        boolean running = true;
        while (running) {
            System.out.println("What do you want to do?");
            System.out.println("1. Explore dungeon");
            System.out.println("2. Save progress");
            System.out.println("3. Upgrade Monster");
            System.out.println("4. Monster Evolution");
            System.out.println("5. Quit");

            int choice = scanner.nextInt();
            System.out.println();
            
            switch (choice) {
                case 1:
                    player.exploreDungeon();
                    break;
                case 2:
                    player.saveProgress();
                    break;
                case 3:
                    player.upgradeMonster();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter again.");
                    break;
            }
        }

        player.closeScanner();
        scanner.close();
    }
}
