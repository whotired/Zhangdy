package test.zhangdy.logging;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.Log4JLogger;

public class LoggingAndLog4jTest {

	private static Log log = new Log4JLogger(LoggingAndLog4jTest.class.getName());
	
	public void printLog(){
		log.debug("This is LoggingAndLog4jTest debug.");
		log.info("This is LoggingAndLog4jTest info.");
		log.warn("This is LoggingAndLog4jTest warn.");
		log.error("This is LoggingAndLog4jTest error.");
		log.fatal("This is LoggingAndLog4jTest fatal.");
	}
}
