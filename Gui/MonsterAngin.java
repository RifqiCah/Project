package Gui;

public class MonsterAngin extends Monster {
    MonsterAngin(String name) {
        super(name, "Angin", "Tanah", "_angin_.gif");  // Wind is strong against Fire
    }
    
    MonsterAngin(String name, int level) {
        super(name, "Angin", "Tanah", level, "_angin_.gif");  // Wind is strong against Fire
    }

    MonsterAngin(String name, int level, int hp, int ep, boolean changed) {
        super(name, level, hp, ep, "Angin", "Tanah", changed, "_angin_.gif");
    }

    MonsterAngin(Monster a) {
        super(a.getName(), a.getLevel(), a.getHp(), a.getEp(), "Angin", "Tanah", true, "_angin_.gif");
    }

    @Override
    public void basicAttack(Monster enemy) {
        System.out.println(getName() + " BASIC ATTACK to " + enemy.getName() + "!");
        int damage = getLevel() * 2;
        enemy.setHp(enemy.getHp() - damage);
        System.out.println(enemy.getName() + " takes " + damage + " damage.");
    }

    @Override
    public void specialAttack(Monster enemy) {
        System.out.println(getName() + " TORNADO STRIKE to " + enemy.getName() + ".");
        int damage = getLevel() * 3;
        enemy.setHp(enemy.getHp() - damage);
        System.out.println(enemy.getName() + " takes " + damage + " damage.");
    }

    @Override
    public void elementalAttack(Monster enemy) {
        System.out.println(getName() + " WIND BLADE to " + enemy.getName() + ".");
        String enemyElement = enemy.getElement();

        if (enemyElement.equals(getStrengthAgainst())) {
            System.out.println("It's super effective!");
            int damage = getLevel() * 4;
            enemy.setHp(enemy.getHp() - damage);
            System.out.println(enemy.getName() + " takes " + damage + " damage.");
        } else {
            int damage = getLevel() * 2;
            enemy.setHp(enemy.getHp() - damage);
            System.out.println(enemy.getName() + " takes " + damage + " damage.");
        }
    }
}
