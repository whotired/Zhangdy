package test.zhangdy.model;

public class Entree {
    
    private boolean vegetarian;
    private String name;
    private double price;
    
    public boolean isVegetarian() { return this.vegetarian; }
    public void setVegetarian(boolean vegetarian) {
      this.vegetarian = vegetarian; 
    }
    
    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }
    
    public double getPrice() { return this.price; }
    public void setPrice(double price) { this.price = price; }
    
  }

  