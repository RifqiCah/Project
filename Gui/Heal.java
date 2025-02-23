package Gui;

public class Heal extends Item {
   @Override
   public void use (Monster pl, Monster en) {
    pl.setHp(pl.getHp() + pl.getLevel() * 2);
    System.out.println(pl.getName() + " get " + pl.getLevel()*2 + " HP");
    System.out.println(pl.getName() + " HP = " + pl.getHp());
    System.out.println();
   }
}
