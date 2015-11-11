package test.zhangdy;

import java.util.Date;

public class TimerWorkTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Date());
		System.out.println(System.currentTimeMillis());
		System.out.println((43*365*24*60 + 6*30*24*60 + 11*24*60 + 2*60 + 40)*60*10);
		//1970-1-1 00
		//2013-7-12 2:40
		//(43*365*24*60 + 6*30*24*60 + 11*24*60 + 2*60 + 40)*60*1000

	}

}
