package Gui;

abstract class Monster {
    private String name;
    private int level;
    private int hp;
    private int ep;
    private String element;
    private String strengthAgainst;
    private boolean changed;
    public boolean hasHeal = true;
    public boolean hasVampire = true;
    private String gif;

    public Monster(String name, String element, String strengthAgainst, String gif) {
        this.name = name;
        this.level = 1;
        this.element = element;
        this.strengthAgainst = strengthAgainst;
        this.setHp();
        this.ep = 0;
        this.changed = false;
        this.gif = gif;
    }

    public Monster(String name, String element, String strengthAgainst, int level, String gif) {
        this.gif = gif;
        this.name = name;
        this.level = level;
        this.element = element;
        this.strengthAgainst = strengthAgainst;
        this.setHp();
        this.ep = 0;
    }

    public Monster(String name, int level, int hp, int ep, String element, String strengthAgainst, boolean changed, String gif) {
        this.gif = gif;
        this.name = name;
        this.level = level;
        this.hp = hp;
        this.ep = ep;
        this.element = element;
        this.strengthAgainst = strengthAgainst;
        this.changed = changed;
    }

    public String getGif() {
        return gif;
    }

    public boolean getChanged() {
        return changed;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getHp() {
        return hp;
    }

    public void setHp() {
        this.hp = level * 10;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getEp() {
        return ep;
    }

    public void setEp(int ep) {
        this.ep = ep;
    }

    public String getElement() {
        return element;
    }

    public String getStrengthAgainst () {
        return strengthAgainst;
    }

    public void setLevel(int level){
        this.level = level;
    }

    public void gainXP(int xp) {
        this.ep += xp;
    }

    public boolean canLevelUp() {
        return this.ep >= 15;
    }

    public void levelUp() {
        if (canLevelUp()) {
            this.ep -= 15;
            this.level++;
            setHp();
            this.changed = false;
            System.out.println(this.name + " has leveled up to level " + this.level + "!");
        }
    }

    public abstract void basicAttack(Monster enemy);

    public abstract void specialAttack(Monster enemy);

    public abstract void elementalAttack(Monster enemy);
    
    public void useItem(String item) {
        System.out.println(getName() + " uses " + item + ".");
        int healingAmount = 20;
        int currentHp = getHp();
        int maxHp = getLevel() * 10;
        int newHp = Math.min(currentHp + healingAmount, maxHp);
        setHp(newHp);
        System.out.println(getName() + " restores " + healingAmount + " HP.");
    }

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