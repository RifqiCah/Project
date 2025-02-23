package Gui;

import java.util.*;
import java.io.*;

class Player {
    private ArrayList<Monster> monsters;
    private Dungeon dungeon;
    private String nama;
    Scanner scanner = new Scanner(System.in);

    public Player(String nama) {
        this.nama = nama;
        this.monsters = new ArrayList<>();

        monsters.add(new MonsterApi("Charmander"));
        monsters.add(new MonsterAir("Squirtle"));
        monsters.add(new MonsterAngin("Pidgeot"));
        monsters.add(new MonsterEs("Pogo"));
        monsters.add(new MonsterTanah("Swayworm"));

        this.dungeon = new Dungeon(this);
    }

    public Player(String nama, ArrayList<Monster> monsters) {
        this.nama = nama;
        this.monsters = monsters;

        this.dungeon = new Dungeon(this);
    }

    public String getName() {
        return nama;
    }

    public ArrayList<Monster> getMonsters () {
        return monsters;
    }

    public void exploreDungeon() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose monsters to bring to the dungeon:");
        ArrayList<Monster> selectedMonsters = new ArrayList<>();
        ArrayList<Monster> avaiMonster = new ArrayList<>(monsters);

        while (selectedMonsters.size() < 3) {
            System.out.println("Select Monster:");
            int count = 1;
            for (Monster m : avaiMonster) {
                System.out.println(count++ + ". " + m.getName() + " - " + m.getElement() + " (lvl. " + m.getLevel() + ")");
            }
            System.out.print("Select Monster: ");
            int slc = scanner.nextInt();
            if (slc > 0 && slc <= avaiMonster.size()) {
                Monster m = avaiMonster.get(slc-1);
                selectedMonsters.add(m);
                avaiMonster.remove(slc-1);

                System.out.println();
                System.out.println("Selected " + m.getName() + " - " + m.getElement() + " (lvl. " + m.getLevel() + ")");
                System.out.print("Select again (Y/n)? ");

                String sel = scanner.next();
                System.out.println();
                if (sel.equalsIgnoreCase("n")) break;
            } else System.out.println("Input invalid!");
        }
        System.out.println();

        // for (int i = 0; i < 3; i++) {
        //     System.out.println("Select monster " + (i + 1) + ":");
        //     for (int j = 0; j < monsters.size(); j++) {
        //         System.out.println((j + 1) + ". " + monsters.get(j).getName() + " (Level: " +
        //                 monsters.get(j).getLevel() + ", HP: " + monsters.get(j).getHp() + ")");
        //     }

        //     System.out.print("Select: ");
        //     int choice = scanner.nextInt();
        //     if (choice < 1 || choice > monsters.size()) {
        //         System.out.println("Invalid choice. Please choose again.");
        //         i--;
        //     } else {
        //         selectedMonsters.add(monsters.get(choice - 1));
        //     }
        //     System.out.println();
        // }

        System.out.println("Exploring the dungeon...");

        boolean fight = true;

        while (fight) {
            Random ran = new Random();
            ArrayList<Monster> monsterList = dungeon.getMonster();
            Monster enemyMonster = monsterList.get(ran.nextInt(monsterList.size()));
            System.out.println("ENEMY FOUND!!!");
            System.out.println(enemyMonster.getName() + " - " + enemyMonster.getElement() + " (lvl. " + enemyMonster.getLevel() + ")");
            System.out.println();

            System.out.println("Your Monster:");
            int count = 1;
            for (Monster a : selectedMonsters) {
                System.out.println(count++ + ". " + a.getName() + " - " + a.getElement() + " (lvl. " + a.getLevel() + ")");
            }
            int select = 0;

            while (select < 1) {
                System.out.print("Select your monster: ");
                select = scanner.nextInt();
                if (select < 1 || select > selectedMonsters.size()) {
                    System.out.println("Input tidak valid!");
                }
            }
            System.out.println();

            Monster monster = selectedMonsters.get(select-1);

            dungeon.startBattle(monster, enemyMonster);
            
            if (monster.getHp() > 0) {
                System.out.println(monster.getName() + " survived the dungeon!");
                // Gain XP is already handled in the dungeon battle
            } else {
                System.out.println(monster.getName() + " fainted and was taken back to the home base.");
                monster.setHp(monster.getLevel() * 10);
                selectedMonsters.remove(select-1);
            }

            if (selectedMonsters.size() == 0) {
                System.out.println("All you monsters are defeated");
                System.out.println("Go to base!");
                System.out.println();
                break;
            }

            System.out.print("Continue explore Dungeon? (y/n): ");
            String inp = scanner.next();

            if (inp.equals("n") || inp.equals("N")) {
                fight = false;
            }
        }
    }

    public boolean upgradeMonster(Monster selectedMonster) {
        if (selectedMonster.canLevelUp()) {
            selectedMonster.levelUp();
            return true;
        } else {
            System.out.println(selectedMonster.getName() + " does not have enough XP to level up.");
            System.out.println();
            return false;
        }
    }

    public void saveProgress() {
        try {
          FileWriter myWriter = new FileWriter("save/" + nama + ".txt");
          for (Monster m : monsters) {
            String mons = m.getName() + " " + m.getLevel() + " " + m.getHp() + " " + m.getEp() + " " + m.getElement() + " " + m.getStrengthAgainst() + " " + m.getChanged();
            myWriter.write(mons + "\n");
          }
          myWriter.close();
          System.out.println("Your progress saved");
        } catch (IOException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
        
        boolean found = false;

        try {
            File myObj = new File("save/user.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              if (data.equals(nama)) found = true;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        if (!found) {
            ArrayList<String> users = new ArrayList<>();
            try {
                File myObj = new File("save/user.txt");
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    users.add(data);
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            
            try {
                FileWriter myWriter = new FileWriter("save/user.txt");
                for (String n : users) myWriter.write(n + "\n");
                myWriter.write(nama + "\n");
                myWriter.close();
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
    }

    public void evolution () {
        System.out.println("Select Monster to evolve");
        int count = 1;
        for (Monster m : monsters) {
            if (m.getChanged()) continue;
            System.out.println(count++ + ". " + m.getName() + " - " + m.getElement() + " (" + m.getLevel() + ")");
        }

        if (count == 1) {
            System.out.println("No monster can evolve!");
        } else {
            System.out.print("Choose: ");
            int choo = scanner.nextInt();
            System.out.println();
            Monster selected = monsters.get(choo-1);

            String e1 = "";
            String e2 = "";
            
            switch (selected.getElement()) {
                case "Air":
                    e1 = "Angin";
                    e2 = "Es";
                    break;
            
                case "Es":
                    e1 = "Air";
                    e2 = "Tanah";
                    break;
        
                case "Tanah":
                    e1 = "Es";
                    e2 = "Api";
                    break;
        
                case "Api":
                    e1 = "Tanah";
                    e2 = "Angin";
                    break;
        
                case "Angin":
                    e1 = "Api";
                    e2 = "Air";
                    break;
        
                default:
                    break;
            }
            
            System.out.println("Evolve to:");
            System.out.println("1. " + e1);
            System.out.println("2. " + e2);
            System.out.print("Choose: ");
            int cho = scanner.nextInt();
            System.out.println();

            String selected2 = cho == 1? e1: e2;
            
            switch (selected2) {
                case "Air":
                    monsters.add(choo-1, new MonsterAir(selected));
                    monsters.remove(choo);
                    break;
            
                case "Es":
                    monsters.add(choo-1, new MonsterEs(selected));
                    monsters.remove(choo);
                    break;
        
                case "Tanah":
                    monsters.add(choo-1, new MonsterTanah(selected));
                    monsters.remove(choo);
                    break;
        
                case "Api":
                    monsters.add(choo-1, new MonsterApi(selected));
                    monsters.remove(choo);
                    break;
        
                case "Angin":
                    monsters.add(choo-1, new MonsterAngin(selected));
                    monsters.remove(choo);
                    break;
            }

            System.out.println(monsters.get(choo-1).getName() + "'s element chaned to " + monsters.get(choo-1).getElement());
            System.out.println();
        }
    }

    public void closeScanner() {
        scanner.close();
    }
}
