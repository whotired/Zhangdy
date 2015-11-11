package test.zhangdy.model;

import java.util.Vector;

public class Menu {
     private Vector entrees;
     private Vector mains;
     private String restaurantName;
     private String phone;
     
     public Menu() {
       this.entrees = new Vector();
       this.mains = new Vector();
     }
     
     public Vector getEntrees() { return this.entrees; }
     public void setEntrees(Vector entrees) { this.entrees = entrees; }
     
     public Vector getMains() { return this.mains; }
     public void setMains(Vector mains) { this.mains = mains; }
     
     public String getRestaurantName() { return this.restaurantName; }
     public void setRestaurantName(String restaurantName) {
       this.restaurantName = restaurantName;
     }
     
     public String getPhone() { return this.phone; }
     public void setPhone(String phone) { this.phone = phone; }
     
     public void addEntree(Entree entree) {
       this.entrees.addElement(entree);
     }
     
     public void addMain(Main main) {
       this.mains.addElement(main);
     }
     
 }
