package test.zhangdy;

import java.io.FileOutputStream;

import org.apache.log4j.HTMLLayout;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.WriterAppender;
import org.apache.log4j.xml.DOMConfigurator;

import test.zhangdy.logging.LoggingAndLog4jTest;

public class LoggingTest {
	private static Logger log = Logger.getLogger(LoggingTest.class); 
	
	public void test() 
	{ 
		log.trace("0000");
		log.debug("111"); 
		log.info("222"); 
		log.warn("333"); 
		log.error("444"); 
		log.fatal("555"); 
		log.setLevel(Level.ALL);
	} 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DOMConfigurator.configure("log4j.xml");
		// TODO Auto-generated method stub
		LoggingTest testLog = new LoggingTest(); 
		testLog.test();
		
		LoggingAndLog4jTest log4j = new LoggingAndLog4jTest();
		log4j.printLog();
		
		HTMLLayout layout = new HTMLLayout();
	    WriterAppender appender = null;
	    try {
	         FileOutputStream output = new FileOutputStream("output2.html");
	         appender = new WriterAppender(layout,output);
	    } catch(Exception e) {}
	    log.addAppender(appender);
	    log.setLevel(Level.DEBUG);
	    log.debug("Here is some DEBUG");
	    log.info("Here is some INFO");
	    log.warn("Here is some WARN");
	    log.error("Here is some ERROR");
	    log.fatal("Here is some FATAL");  
	}

}
