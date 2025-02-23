package Gui;

public class MonsterApi extends Monster {
    MonsterApi (String name) {
        super (name, "Api", "Es", "_api_.gif");
    }

    MonsterApi (String name, int level) {
        super (name, "Api", "Es", level, "_api_.gif");
    }

    MonsterApi(String name, int level, int hp, int ep, boolean changed) {
        super(name, level, hp, ep, "Api", "Es", changed, "_api_.gif");
    }

    MonsterApi(Monster a) {
        super(a.getName(), a.getLevel(), a.getHp(), a.getEp(), "Api", "Es", true, "_api_.gif");
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
        System.out.println(getName() + " VENGEANCE FLAME to " + enemy.getName() + ".");
        int damage = getLevel() * 3;
        enemy.setHp(enemy.getHp() - damage);
        System.out.println(enemy.getName() + " takes " + damage + " damage.");
    }

    @Override
    public void elementalAttack(Monster enemy) {
        System.out.println(getName() + " FIRE DANCE to " + enemy.getName() + ".");
        String enemyElement = getElement();

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