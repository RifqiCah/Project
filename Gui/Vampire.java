package Gui;

public class Vampire extends Item {
    @Override
    public void use(Monster pl, Monster en) {
        pl.setHp(pl.getHp() + pl.getLevel());
        en.setHp(en.getHp() - pl.getLevel());
        System.out.println(pl.getName() + " take " + pl.getLevel() + " from " + en.getName());
        System.out.println(pl.getName() + " HP = " + pl.getHp());
        System.out.println(en.getName() + " HP = " + en.getHp());
        System.out.println();
    }
}