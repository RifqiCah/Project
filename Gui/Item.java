package Gui;

public abstract class Item implements Usable {
   boolean available;

   Item () {
       this.available = true;
   }

   @Override
   public void use(Monster pl, Monster en) {};
}