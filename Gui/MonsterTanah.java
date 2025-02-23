package Gui;

public class MonsterTanah extends Monster {
    MonsterTanah(String name) {
        super(name, "Tanah", "Air", "_tanah_.gif");  // Ground is strong against Electric
    }
    
    MonsterTanah(String name, int level) {
        super(name, "Tanah", "Air", level, "_tanah_.gif");  // Ground is strong against Electric
    }

    MonsterTanah(String name, int level, int hp, int ep, boolean changed) {
        super(name, level, hp, ep, "Tanah", "Air", changed, "_tanah_.gif");
    }

    MonsterTanah(Monster a) {
        super(a.getName(), a.getLevel(), a.getHp(), a.getEp(), "Tanah", "Air", true, "_tanah_.gif");
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
        System.out.println(getName() + " EARTHQUAKE to " + enemy.getName() + ".");
        int damage = getLevel() * 3;
        enemy.setHp(enemy.getHp() - damage);
        System.out.println(enemy.getName() + " takes " + damage + " damage.");
    }

    @Override
    public void elementalAttack(Monster enemy) {
        System.out.println(getName() + " SANDSTORM to " + enemy.getName() + ".");
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
