/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */ 
package test.zhangdy;

import java.util.*;
import java.io.*;

public class Anagrams {
	public static void main1(){
		/*HashMap 的key或value都允许null
		 * Hashtable的key或value都不允许null，否则报运行时异常NullPointerException
		 * Set允许null，不允许重复的元素，所以对已存在的元素的add操作，返回值是false，Set仍只包含一个元素
		 * List允许null，允许重复的元素，所以对已存在的元素的add操作，返回值是true，List变成包含两个该元素
		 * */
		//HashMap
		Map<String,String> m = new HashMap<String,String>();
		m.put(null,null);
		m.put(null, "1");
		System.out.println(m);
		//Hashtable
		Map<String,String> t = new Hashtable<String,String>();
		t.put(null,null);
		System.out.println(t);
		//Set
		Set s = new HashSet();
		s.add(null);
		boolean success = s.add(null);
		System.out.println(s);
		System.out.println(success);
		//List
		List l = new ArrayList();
		l.add(null);
		boolean successl = l.add(null);
		System.out.println(l);
		System.out.println(successl);
		/*output:
		 * {null=null}
			[null]
			false
			[null, null]
			true
		 */
	}
    public static void main(String[] args) {
    	main1();
        int minGroupSize = Integer.parseInt(args[1]);

        // Read words from file and put into a simulated multimap
        Map<String, List<String>> m = new HashMap<String, List<String>>();

        try {
        	Anagrams an = new Anagrams();
        	String dr = an.getClass().getResource("").getPath().replace("%20", " ");
            Scanner s = new Scanner(new File(dr+"/"+args[0]));
            while (s.hasNext()) {
                String word = s.next();
                String alpha = alphabetize(word);
                List<String> l = m.get(alpha);
                if (l == null)
                    m.put(alpha, l=new ArrayList<String>());
                l.add(word);
            }
        } catch (IOException e) {
            System.err.println(e);
            System.exit(1);
        }

        // Print all permutation groups above size threshold
        for (List<String> l : m.values())
            if (l.size() >= minGroupSize)
                System.out.println(l.size() + ": " + l);
    }

    private static String alphabetize(String s) {
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }
}
