package test.zhangdy.parser;

import test.zhangdy.model.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MenuHandler extends DefaultHandler {
  
  private Menu menu;
  private Entree currentEntree;
  private Main currentMain;
  private String characterValue;
  private StringBuffer entreeName;
  private StringBuffer mainName;
  private StringBuffer mainDesc;  
  
  public MenuHandler() {    
  }
  
  public Menu getMenu() {
    if(menu == null) { throw new IllegalStateException("Menu not ready yet"); }
    else return this.menu;
  }
  
  public void startElement(
    String uri, String localName, String qName, Attributes attributes) 
    throws SAXException {
    
    // start with the menu root element
    if(qName.equals("menu")) {
      
      if (menu == null) { 
        
        String restaurantName = attributes.getValue("restaurantName");
        String phone = attributes.getValue("phone");
       
        if(restaurantName == null || phone == null) {
          throw new IllegalArgumentException(
            "A menu must have both restuarantName and phone");
        }
        
        // if we are here, the menu element is well formed - let's create it
        this.menu = new Menu(); 
        this.menu.setRestaurantName(restaurantName);
        this.menu.setPhone(phone);        
        
      } else {
        throw new IllegalStateException("Cannot have duplicate menu items");
      } 
      
    } else if(qName.equals("entree")) {
      
      // process the entree element - this must be inside an existing
      // menu element
      if(menu == null) { 
        throw new IllegalStateException("Missing root Menu Element"); 
      } else if(currentEntree != null) {
        throw new IllegalStateException("Already processing an Entree!");        
      } else {
        
        // create the entree and set the vegetarian attribute
        // the rest of the values of the entree will be filled by the 
        // processing of the other elements
        currentEntree = new Entree();
        String vegetarian = attributes.getValue("veg");
        if(vegetarian == null) {
          // assume default value of N
          vegetarian = "N";
        }
        currentEntree.setVegetarian(vegetarian.equals("Y"));
      }
      
      
    } else if(qName.equals("main")) {
      
      // process the main element - this must be inside an existing
      // menu element
      if(menu == null) { 
        throw new IllegalStateException("Missing root Menu Element"); 
      } else if(currentMain != null) {
        throw new IllegalStateException("Already processing a Main!");        
      } else {
        
        // create the main and set the vegetarian attribute
        // the rest of the values of the main will be filled by the 
        // processing of the other elements
        currentMain = new Main();
        String vegetarian = attributes.getValue("veg");
        if(vegetarian == null) {
          // assume default value of N
          vegetarian = "N";
        }
        currentMain.setVegetarian(vegetarian.equals("Y"));
      }      
      
    } else if(qName.equals("name")) {
      // now this could be for either a main or an entree
      if(currentEntree == null && currentMain == null) {
        throw new IllegalStateException(
          "Name element without an entree or main");
      } else if(currentEntree != null && currentMain != null) {
        throw new IllegalStateException("Can't match name to entree AND main");
      } else if(currentEntree == null && currentMain != null) { 
        mainName = new StringBuffer();
      } else { // only option left
        entreeName = new StringBuffer();
      }
      
    } else if(qName.equals("price")) {
      // this could also be for either a main or an entree
      if(currentEntree == null && currentMain == null) {
        throw new IllegalStateException(
          "Price element without an entree or main");
      } else if(currentEntree != null && currentMain != null) {
        throw new IllegalStateException("Can't match price to entree AND main");
      } else { // do nothing - will be handled by the endElement method
      }      
    } else if(qName.equals("description")) {
      // this will be only for the main
      if(currentMain == null) {
        throw new IllegalStateException(
          "Description element without a main");
      } else {
        mainDesc = new StringBuffer();
      }
      
    } else {
      throw new IllegalArgumentException("Unsupported Element");
    }
    
  }
  
  public void endElement(
    String uri, String localName, String qName) throws SAXException {

    if(qName.equals("entree")) {
      // the entree object is complete -- add to the menu
      menu.addEntree(currentEntree);
      currentEntree = null; // we don't need this object now, set to null
    } else if(qName.equals("main")) {
      menu.addMain(currentMain);
      currentMain = null; // we don't need this object now, set to null
    } else if(qName.equals("name")) {
      if (currentEntree != null && currentMain == null) {
        currentEntree.setName(entreeName.toString());
        entreeName = null;
      } else {
        currentMain.setName(mainName.toString());
        mainName = null;
      }
    } else if(qName.equals("price")) {
      if(currentEntree != null && currentMain == null) {
        currentEntree.setPrice(Double.parseDouble(characterValue));
      } else {
        currentMain.setPrice(Double.parseDouble(characterValue));
      }
    } else if(qName.equals("description")) {
      currentMain.setDescription(mainDesc.toString());
      mainDesc = null;      
    }
    
  }
  
  
  public void characters(char[] ch, int start, int length) throws SAXException {
    characterValue = new String(ch, start, length).trim();
    if(entreeName != null) {
      entreeName.append(characterValue).append(" ");
    } else if(mainName != null) {
      mainName.append(characterValue).append(" ");
    } else if(mainDesc != null) {
      mainDesc.append(characterValue).append(" ");
    }
  }
  
}