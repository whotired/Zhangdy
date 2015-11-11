package test.zhangdy.security;

import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;

public class SystemTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Retrieve all System properties
		Properties pros = System.getProperties();
		Set<String> prosNames = pros.stringPropertyNames();
		TreeSet<String> soredProsNames = new TreeSet(prosNames);
		System.out.println("============  System Property ==============================");
		for (String key : soredProsNames){
			System.out.println(key +"="+pros.getProperty(key));
		}
		// retrieve all environment variables
		Map<String,String> envs = System.getenv();
		TreeSet<String> soredEnvNames = new TreeSet(envs.keySet());
		System.out.println("============  Environment Variables ==============================");
		for(String key : soredEnvNames){
			System.out.println(key +"="+envs.get(key));
		}
	}

}
