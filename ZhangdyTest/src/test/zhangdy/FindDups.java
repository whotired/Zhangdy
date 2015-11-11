//**********************************************************************
//IBM Confidential OCO Source Materials
//Program Number xxxx-xxx
//Copyright (c) 2008 IBM Corp. All Rights Reserved.
//The source code for this program is not published or otherwise
//divested of its trade secrets, irrespective of what has been
//deposited with the U.S. Copyright Office.
//*********************************************************************
package test.zhangdy;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

public class FindDups extends TestCase {

	@Before
	public void setUp() throws Exception {
	}
	/**
	 * s.add(e): if it returns false means e already exits in s.
	 * the output of HashSet/TreeSet/LinkedHashSet
	 */
	@Test
	public void testSetBasicOperation(){
		Set<String> s = new TreeSet<String>();
		String[] args = {"i","came","i","saw","i","left"};
        for (String a : args)
            if (!s.add(a))
                System.out.println("Duplicate detected: " + a);

        System.out.println(s.size() + " distinct words: " + s);
	}
	/**
	 * 
	 */
	public void testSetBulkOperation(){
		String[] args = {"i","came","i","saw","i","left"};
		Set<String> uniques = new HashSet<String>();
        Set<String> dups    = new HashSet<String>();
        
        for (String a : args){
        	if (!uniques.add(a))
                dups.add(a);
            
        }
        // Destructive set-difference
        Set<String> union = new HashSet<String>(uniques);
        Set<String> intersection = new HashSet<String>(uniques);
		Set<String> difference = new HashSet<String>(uniques);
        union.addAll(dups);
        intersection.retainAll(dups);
        difference.removeAll(dups);
        uniques.removeAll(dups);
        

        System.out.println("Unique words:    " + uniques);
        System.out.println("Duplicate words: " + dups);
        System.out.println("union: " + union);
        System.out.println("intersection: " + intersection);
        System.out.println("difference: " + difference);
        /*output:
         * 	Unique words:    [came, left, saw]
			Duplicate words: [i]
			union: [came, left, i, saw]
			intersection: [i]
			difference: [came, left, saw]
         */
	}
	public void test1(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String end = "2222-1-1";
		try {
			Date endDate = sdf.parse(end);
			System.out.println(endDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
