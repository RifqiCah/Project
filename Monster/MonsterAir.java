package Monster;
import Monster.Monster;

public class MonsterAir extends Monster {
    public MonsterAir(String name) {
        super(name, "Air", "Api");  // Water is strong against Fire
    }
    
    public MonsterAir(String name, int level) {
        super(name, "Air", "Api", level);  // Water is strong against Fire
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
        System.out.println(getName() + " HYDRO PUMP to " + enemy.getName() + ".");
        int damage = getLevel() * 3;
        enemy.setHp(enemy.getHp() - damage);
        System.out.println(enemy.getName() + " takes " + damage + " damage.");
    }

    @Override
    public void elementalAttack(Monster enemy) {
        System.out.println(getName() + " TSUNAMI to " + enemy.getName() + ".");
        String enemyElement = enemy.getElement();

        if (enemyElement.equals(getStrengthAgainst())) {
            System.out.println("It's super effective!");
            int damage = getLevel() * 3;
            enemy.setHp(enemy.getHp() - damage);
            System.out.println(enemy.getName() + " takes " + damage + " damage.");
        } else {
            int damage = getLevel() * 2;
            enemy.setHp(enemy.getHp() - damage);
            System.out.println(enemy.getName() + " takes " + damage + " damage.");
        }
    }
}
