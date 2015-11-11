package test.zhangdy;

import java.io.File;
import java.io.InputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import test.zhangdy.model.Menu;
import test.zhangdy.parser.MenuHandler;

public class XmlParserTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// stream to read the file in
	    InputStream is = null;
	    
	    try {
	      
	      // let's read the XML file and parse it using the SAXParser
	      //is = XmlParserTest.class.getResourceAsStream("menu.xml");

	      // load the handler
	      MenuHandler saxMenuHandler = new MenuHandler();
	      
	      // instantiate a SAXParser object
	      SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
	      
	      // and parse away
//	      parser.parse(is, saxMenuHandler);
	      File file = new File("menu.xml");
	      parser.parse(file, saxMenuHandler);  
	      
	      // if we are here, there have been no errors, so let us display the 
	      // results on the screen
	      Menu menu = saxMenuHandler.getMenu();
	      System.out.println(menu);
	       

	    } catch(Exception e) {
	      
	    } finally { try { if(is != null) is.close(); } catch(Exception ex) {} }
	    
	}

}
