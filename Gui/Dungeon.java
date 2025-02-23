package Gui;

import java.util.*;
class Dungeon {
    private ArrayList<Monster> wildMonsters;
    private Player player;

    public Dungeon(Player player) {
        this.wildMonsters = new ArrayList<>();
        this.player = player;
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
        ArrayList<Monster> playerMons = player.getMonsters();

        int lvlMax = 0;
        for (Monster m : playerMons) {
            lvlMax = Math.max(lvlMax, m.getLevel());
        }

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
            int lvl;
            if (lvlMax <= 1) {
                lvl = 1;
            } else {
                lvl = random.nextInt(lvlMax-1) + 1;
            }
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

        enemyMonster.setHp();
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
            System.out.print("Select (1/2/3/4/5): ");

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            System.out.println();
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
                    System.out.println("Item available: ");
                    if (playerMonster.hasHeal) System.out.println("- Heal");
                    if (playerMonster.hasVampire) System.out.println("- Vampire");
                    System.out.print("Select: ");
                    String itm = scanner.next();
                    System.out.println();
                    
                    if (itm.equalsIgnoreCase("Heal")) {
                        Heal heal = new Heal();
                        heal.use(playerMonster, enemyMonster);
                        playerMonster.hasHeal = false;
                    }
                    if (itm.equalsIgnoreCase("Vampire")) {
                        Vampire vamp = new Vampire();
                        vamp.use(playerMonster, enemyMonster);
                        playerMonster.hasVampire = false;
                    }
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

            System.out.println(enemyMonster.getName() + " HP: " + Math.max(0, enemyMonster.getHp()));
            System.out.println();

            if (enemyMonster.getHp() <= 0) {
                System.out.println("You defeated " + enemyMonster.getName() + "!");

                int lvlDif = enemyMonster.getLevel() - playerMonster.getLevel();
                if (lvlDif <= 0) lvlDif = 0;

                playerMonster.gainXP(4 + lvlDif); // Gain XP after defeating the enemy
                System.out.println(playerMonster.getName() + " XP +" + (4 + lvlDif));
                System.out.println();
                generateMonsters();
                break;
            }

            System.out.println();
            System.out.println("Enemy's turn:");
            int enemyAtt = random.nextInt(3) + 1;
            
            switch (enemyAtt) {
                case 1:
                    enemyMonster.basicAttack(playerMonster);
                    break;
            
                case 2:
                enemyMonster.specialAttack(playerMonster);
                break;
        
                case 3:
                enemyMonster.elementalAttack(playerMonster);
                break;
        
                default:
                    break;
            }

            System.out.println(playerMonster.getName() + " HP: " + Math.max( 0, playerMonster.getHp()));
            System.out.println();

            if (playerMonster.getHp() <= 0) {
                System.out.println(enemyMonster.getName() + " defeated you!");
                generateMonsters();
                break;
            }
            System.out.println();
        }
    }
}