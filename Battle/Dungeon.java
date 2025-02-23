package Battle;


import java.util.*;

import Monster.Monster;
import Monster.MonsterAir;
import Monster.MonsterAngin;
import Monster.MonsterApi;
import Monster.MonsterEs;
import Monster.MonsterTanah;

import java.io.*;
public class Dungeon {
    private ArrayList<Monster> wildMonsters;

    public Dungeon() {
        this.wildMonsters = new ArrayList<>();
        generateMonsters();
    }

    public ArrayList<Monster> getMonster() {
        return wildMonsters;
    }

    // private void generateMonsters() {
    //     Random random = new Random();
    //     String[] elements = {"Api", "Angin", "Air", "Es", "Tanah"};

    //     int numMonsters = random.nextInt(5) + 1;
    //     for (int i = 0; i < numMonsters; i++) {
    //         String name = "Monster" + (i + 1);
    //         int level = random.nextInt(10) + 1;
    //         String element = elements[random.nextInt(elements.length)];
    //         Monster monster = new BasicMonster(name, level, element, strengthAgainst);
    //         wildMonsters.add(monster);
    //     }
    // }

    private void generateMonsters() {
        Random random = new Random();
        String[] elements = {"Api", "Angin", "Air", "Es", "Tanah"};
        String[] namaMonster = {
            "Shadowfang", "Dreadmaw", "Infernalix", "Frostbite", "Venomspine",
            "Thunderclaw", "Nightshade", "Doombringer", "Blazefury", "Grimreaper",
            "Voidspawn", "Frostfire", "Razorwing", "Deathclaw", "Abyssal Terror",
            "Gloomfang", "Hellforge", "Stormcaller", "Darkthorn", "Soulrender"
        };

        for (int a = 0; a < 10; a++) {
            int numMonsters = random.nextInt(5);
            int numNama = random.nextInt(20);
            int lvl = random.nextInt(98) + 1;
            String el = elements[numMonsters];

            switch (el) {
                case "Api":
                    wildMonsters.add(new MonsterApi(namaMonster[numNama], lvl));
                    break;
            
                case "Angin":
                wildMonsters.add(new MonsterAngin(namaMonster[numNama], lvl));
                break;
        
                case "Es":
                wildMonsters.add(new MonsterEs(namaMonster[numNama], lvl));
                break;
        
                case "Tanah":
                wildMonsters.add(new MonsterTanah(namaMonster[numNama], lvl));
                break;
        
                case "Air":
                wildMonsters.add(new MonsterAir(namaMonster[numNama], lvl));
                break;
        
                default:
                    break;
            }
        }
    }

    public void startBattle(Monster playerMonster, Monster enemyMonster) {
        Random random = new Random();

        System.out.println("A battle has started!");
        System.out.println("Your " + playerMonster.getName() + " (Level: " + playerMonster.getLevel() +
                ", HP: " + playerMonster.getHp() + ") vs " + enemyMonster.getName() + " (Level: " +
                enemyMonster.getLevel() + ", HP: " + enemyMonster.getHp() + ")");
        System.out.println();

        while (playerMonster.getHp() > 0 && enemyMonster.getHp() > 0) {
            System.out.println("Your turn:");
            System.out.println("1. Basic Attack");
            System.out.println("2. Special Attack");
            System.out.println("3. Elemental Attack");
            System.out.println("4. Use Item");
            System.out.println("5. Flee");

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    playerMonster.basicAttack(enemyMonster);
                    break;
                case 2:
                    playerMonster.specialAttack(enemyMonster);
                    break;
                case 3:
                    playerMonster.elementalAttack(enemyMonster);
                    break;
                case 4:
                    System.out.println("Enter (heal): ");
                    String item = scanner.next();
                    playerMonster.useItem(item);
                    break;
                case 5:
                    if (playerMonster.flee()) {
                        System.out.println("You successfully fled from the battle.");
                        return;
                    } else {
                        System.out.println("You failed to flee.");
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
                    break;
            }

            if (enemyMonster.getHp() <= 0) {
                System.out.println("You defeated " + enemyMonster.getName() + "!");
                playerMonster.gainXP(20); // Gain XP after defeating the enemy
                break;
            }

            System.out.println();
            System.out.println("Enemy's turn:");
            enemyMonster.basicAttack(playerMonster);

            if (playerMonster.getHp() <= 0) {
                System.out.println(enemyMonster.getName() + " defeated you!");
                break;
            }
            System.out.println();
        }
    }
}