package Gui;

public class MonsterEs extends Monster {
    MonsterEs(String name) {
        super(name, "Es", "Angin", "_es_.gif");  // Ice is strong against Ground
    }

    MonsterEs(String name, int level) {
        super(name, "Es", "Angin", level, "_es_.gif");  // Ice is strong against Ground
    }

    MonsterEs(String name, int level, int hp, int ep, boolean changed) {
        super(name, level, hp, ep, "Es", "Angin", changed, "_es_.gif");
    }

    MonsterEs(Monster a) {
        super(a.getName(), a.getLevel(), a.getHp(), a.getEp(), "Es", "Angin", true, "_es_.gif");
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
        System.out.println(getName() + " FROST BITE to " + enemy.getName() + ".");
        int damage = getLevel() * 3;
        enemy.setHp(enemy.getHp() - damage);
        System.out.println(enemy.getName() + " takes " + damage + " damage.");
    }

    @Override
    public void elementalAttack(Monster enemy) {
        System.out.println(getName() + " BLIZZARD to " + enemy.getName() + ".");
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
