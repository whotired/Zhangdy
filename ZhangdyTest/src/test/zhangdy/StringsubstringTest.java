package test.zhangdy;

import java.util.ArrayList;
import java.util.ListIterator;

public class StringsubstringTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String justification="";
		ArrayList custNums = new ArrayList();
		custNums.add("abc\n");
		custNums.add("efghi ");
		custNums.add("lmn opq; rst.;\n");
		custNums.add("zyy; \n");
		for(ListIterator custIter = custNums.listIterator();custIter.hasNext();){
			String just = (String)custIter.next();
			int index = custIter.nextIndex();
//			System.out.println(index +" "+just + "|");
			if (just!=null && !just.isEmpty()) {
				just = just.trim();
//				System.out.println("just = "+just + "|");
//				if (just.endsWith(";")){
////					just = just.substring(0, just.length() - 1);
//					just += " ";
//				}else if (index != custNums.size()){
//					just += "\n";
//				}
			} 
			justification += just+ "\n";
		}
		System.out.println(justification);
//		if (justification!=null && !justification.isEmpty()){
//			justification = justification.trim();
//			if (justification.endsWith(";")){
//				justification = justification.substring(0, justification.length() - 1);
//			}        	
//		}
//		System.out.println("justification = "+justification+ "|");
		  
	}

}
