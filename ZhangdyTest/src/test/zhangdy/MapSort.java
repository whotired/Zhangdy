package test.zhangdy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class MapSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MapSort mapSort  = new MapSort();
		mapSort.testHashMap();
		mapSort.testLinkedMap();
		mapSort.testLinkedMap2();
		mapSort.testLinkedMapSortViaValue();
		mapSort.testTreeMapSortViaKey();
		mapSort.testTreeMapSortViaValue();
	}
	
	public void testHashMap(){
		Map<String, String> map = new HashMap<String, String>();

		map.put("a3", "aa");

		map.put("a2", "bb");

		map.put("b1", "cc");

		for (Iterator iterator = map.values().iterator(); iterator.hasNext();) {

			String name = (String) iterator.next();

			System.out.println(name);

		}
		/*
		 * result:	bb
					aa
					cc
			ps: 与放入 Map 的顺序不同
		 */
	}
	
	public void testLinkedMap(){
		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put("a3", "dd");  
		map.put("a2", "bb");
		map.put("b1", "cc");

		for (Iterator iterator = map.values().iterator(); iterator.hasNext();) {

			String name = (String) iterator.next();

			System.out.println(name);

		}
		/*
		 * result:	dd
					bb
					cc
			ps: 与放入 Map 的顺序相同
		 */
		
		
		Map<String, List> map2 = new LinkedHashMap<String, List>();
		
		List list1 = new ArrayList();
		list1.add("aa1");
		list1.add("aa2");
		List list2 = new ArrayList();
		list2.add("bb1");
		list2.add("bb2");
		List list3 = new ArrayList();
		list3.add("cc1");
		list3.add("cc2");
		map2.put("a3", list2);  
		map2.put("a2", list1);
		map2.put("b1", list3);

		for (Iterator iterator = map2.values().iterator(); iterator.hasNext();) {

			List list = (ArrayList) iterator.next();

			System.out.println(list.toString());

		}
		/*
		 * result:	[bb1, bb2]
					[aa1, aa2]
					[cc1, cc2]
			ps: 与放入 Map 的顺序相同
		 */
	}
	
	public void testLinkedMap2(){
		Map<String, String> linkedMap = new LinkedHashMap<String, String>();
		linkedMap.put("aaa", "ddd");
		linkedMap.put("bbb", "bbb");
		linkedMap.put("ccc", "ccc");
		linkedMap.put("aaa", "aaa");
		Iterator ite = linkedMap.entrySet().iterator();
		while (ite.hasNext()) {
			System.out.println("linkeMap:" + ((Map.Entry)ite.next()).getValue());
		}
		
		/*
		 * result:  linkeMap:aaa
					linkeMap:bbb
					linkeMap:ccc
 			ps: 与放入 Map 的顺序相同, aaa 覆盖了 ddd
		 */
	}
	
	public void testLinkedMapSortViaValue(){
		Map<String, Integer> myMap = new LinkedHashMap();  
        myMap.put("a", 1);  
        myMap.put("b", 4);  
        myMap.put("c", 3);  
        myMap.put("d", 9);  
        myMap.put("e", 6);  
        myMap.put("f", 2); 
        myMap.put("g", 9);
          
        System.out.println("unsorted map: "+myMap);  
          
        myMap = sortMap(myMap);  
          
        System.out.println("sorted map: "+myMap); 
        
        /*
         * result:	unsorted map: {a=1, b=4, c=3, d=9, e=6, f=2, g=9}
					sorted map: {a=1, f=2, c=3, b=4, e=6, d=9, g=9}
         */
	}
	public static Map sortMap(Map oldMap) {  
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(oldMap.entrySet());  
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {  
  
            @Override  
            public int compare(Entry<java.lang.String, Integer> arg0,  
                    Entry<java.lang.String, Integer> arg1) {  
                return arg0.getValue() - arg1.getValue();  
            }  
        });  
        Map newMap = new LinkedHashMap();  
        for (int i = 0; i < list.size(); i++) {  
            newMap.put(list.get(i).getKey(), list.get(i).getValue());  
        }  
        return newMap;  
    } 
	
	/** Sort TreeMap via the key in the TreeMap*/
	public void testTreeMapSortViaKey() {      

		Map<String, String> map = new TreeMap<String, String>(
				new Comparator<Object>() {

					public int compare(Object o1, Object o2) {

						String key1 = o1.toString();

						String key2 = o2.toString();

						return key1.compareTo(key2);

					}
				});

		map.put("3", "aa");

		map.put("2", "bb");

		map.put("1", "cc");

		for (Iterator iterator = map.values().iterator(); iterator.hasNext();) {

			String name = (String) iterator.next();

			System.out.println(name);

		}

		/*
		 * result:  cc
					bb
					aa
 			ps: 按照 key 的顺序打印出 value
		 */
	}

	/** Sort TreeMap via the value in the TreeMap*/
	public void testTreeMapSortViaValue() { 
		//Create a local class implements Comparator, pass the Map object need to be sorted into constructor
		class ValueComparator implements Comparator<String> {  
			  
		    Map<String, Double> base;  
		    public ValueComparator(Map<String, Double> base) {  
		        this.base = base;  
		    }  
		  
		    // Note: this comparator imposes orderings that are inconsistent with equals.      
		    public int compare(String a, String b) { 
		    	if (base.get(a) <= base.get(b)) {  
		            return -1;  
		        } else {  
		            return 1;  
		        } // returning 0 would merge keys   
		    }  
		}  
		
		HashMap<String,Double> map = new HashMap<String,Double>();  
        ValueComparator bvc =  new ValueComparator(map);  
        TreeMap<String,Double> sorted_map = new TreeMap<String,Double>(bvc);  
  
        map.put("A",99.5);  
        map.put("B",67.4);  
        map.put("C",67.4);  
        map.put("D",67.3);  
  
        System.out.println("unsorted map: "+map);  
  
        sorted_map.putAll(map);  
  
        System.out.println("sorted map: "+sorted_map);  
        
        /*
         * result: 	unsorted map: {A=99.5, B=67.4, C=67.4, D=67.3}
					sorted map: {D=67.3, C=67.4, B=67.4, A=99.5}
         */
	}
}
