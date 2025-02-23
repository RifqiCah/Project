package Monster;
import Monster.Monster;

class BasicMonster extends Monster {
    public BasicMonster(String name, int level, String element, String strengthAgainst) {
        super(name, element, strengthAgainst);
        setLevel(level);
    }
    

    @Override
    public void basicAttack(Monster enemy) {
        System.out.println(getName() + " performs a basic attack on " + enemy.getName() + ".");
        int damage = getLevel() * 2;
        enemy.setHp(enemy.getHp() - damage);
        System.out.println(enemy.getName() + " takes " + damage + " damage.");
    }

    @Override
    public void specialAttack(Monster enemy) {
        System.out.println(getName() + " performs a special attack on " + enemy.getName() + ".");
        int damage = getLevel() * 3;
        enemy.setHp(enemy.getHp() - damage);
        System.out.println(enemy.getName() + " takes " + damage + " damage.");
    }

    @Override
    public void elementalAttack(Monster enemy) {
        System.out.println(getName() + " performs an elemental attack on " + enemy.getName() + ".");
        String playerElement = enemy.getElement();
        String enemyElement = getElement();

        if (playerElement.equals(enemyElement)) {
            int damage = getLevel() * 2;
            enemy.setHp(enemy.getHp() - damage);
            System.out.println(enemy.getName() + " takes " + damage + " damage.");
        } else {
            System.out.println("It's super effective!");
            int damage = getLevel() * 3;
            enemy.setHp(enemy.getHp() - damage);
            System.out.println(enemy.getName() + " takes " + damage + " damage.");
        }
    }

    @Override
    public boolean flee() {
        System.out.println(getName() + " attempts to flee.");
        boolean success = Math.random() < 0.5;
        if (success) {
            System.out.println(getName() + " successfully fled from the battle.");
        } else {
            System.out.println(getName() + " failed to flee.");
        }
        return success;
    }

    @Override
    public void battle(Monster enemy) {
        while (getHp() > 0 && enemy.getHp() > 0) {
            basicAttack(enemy);
            if (enemy.getHp() <= 0) {
                System.out.println(enemy.getName() + " fainted!");
                break;
            }
            enemy.basicAttack(this);
            if (getHp() <= 0) {
                System.out.println(getName() + " fainted!");
                break;
            }
        }
    }
}