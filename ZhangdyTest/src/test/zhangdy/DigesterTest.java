package test.zhangdy;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import org.apache.commons.digester.Digester;
import org.apache.commons.digester.ObjectCreateRule;
import org.apache.commons.digester.Rule;
import org.apache.commons.digester.xmlrules.DigesterLoader;
import org.xml.sax.SAXException;

public class DigesterTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pkgTypeDefFile = "/home/webapps/shopz/data-in/xml/PkgType.xml";
		String pkgTypeRulesFile = "/home/webapps/shopz/data-in/xml/PkgTypeRules.xml";
		File input = new File(pkgTypeDefFile);
		File rules = new File(pkgTypeRulesFile);        
		
		try{
			System.out.println("input=" + input.getPath());
            System.out.println("rules=" + rules.getPath());
            System.out.println("rules.toURI()=" + rules.toURI());
            System.out.println("rules.toURI().toURL()=" + rules.toURI().toURL());
			Digester digester = DigesterLoader.createDigester(rules.toURI().toURL());
			Rule rule = new ObjectCreateRule("com.ibm.swot.controldata.OpEnvTO");
			digester.addRule("OperatingEnv", rule);
			digester.addObjectCreate("OperatingEnv", "com.ibm.swot.controldata.OpEnvTO");
//            digester.setClassLoader(getClass().getClassLoader());
//            digester.setLogger(logger);
            ArrayList groups = (ArrayList) digester.parse(input);
            
            System.out.println("groups=" + groups.size());
            
        } catch(MalformedURLException e){
            e.printStackTrace();
            
        } catch(IOException e){
        	e.printStackTrace();
            
        } catch(SAXException e){
        	e.printStackTrace();
            
        }
		
//		File input =new File( DigesterTest.class.getResource("/resources/PkgType.xml").getFile());
//		final URL pkgTypeRulesURL = DigesterTest.class.getResource("/resources/PkgTypeRules.xml");
//		try{
//			System.out.println("input=" + input.getPath());
//            System.out.println("rules=" + pkgTypeRulesURL.toString());
//			Digester digester = DigesterLoader.createDigester(pkgTypeRulesURL);
////            digester.setClassLoader(getClass().getClassLoader());
////            digester.setLogger(logger);
//            ArrayList groups = (ArrayList) digester.parse(input);
//            
//            System.out.println("groups=" + groups.size());
//            
//        } catch(MalformedURLException e){
//            e.printStackTrace();
//            
//        } catch(IOException e){
//        	e.printStackTrace();
//            
//        } catch(SAXException e){
//        	e.printStackTrace();
//            
//        }
	}

}
