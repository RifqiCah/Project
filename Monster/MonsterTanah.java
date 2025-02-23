package Monster;
import Monster.Monster;

public class MonsterTanah extends Monster {
    public MonsterTanah(String name) {
        super(name, "Tanah", "Air");  // Ground is strong against Electric
    }
    
    public MonsterTanah(String name, int level) {
        super(name, "Tanah", "Air", level);  // Ground is strong against Electric
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
