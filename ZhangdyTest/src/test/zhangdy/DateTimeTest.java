package test.zhangdy;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

import com.ibm.shopcbs.utility.DateTimeUtilities;

public class DateTimeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String timeStamp = "2013-06-24 21:11:49.0";//UTC
		Locale locale = Locale.US;//new Locale("zh","CN");//new Locale("zh","CN");//Locale.getDefault();//new Locale("en","ZZ");
		
		String timezoneOffset = "-480";//new Integer(date.getTimezoneOffset()).toString();
		DateFormat df =
			DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String offsetDate;
        GregorianCalendar calendar = getGregCalendar(timeStamp);
        df.setCalendar(calendar);
        if (null != timezoneOffset ) { //return date as local time
            int offset = Integer.parseInt(timezoneOffset);
            calendar.add(Calendar.MINUTE, (0 - offset));            
            offsetDate = df.format(calendar.getTime());
//            offsetDate = offsetDate.substring(0, offsetDate.length() - 4);//remove the last 4 string: " "+timezone
        }
        else { //return date as UTC
            offsetDate = df.format(calendar.getTime()) + " UTC";
        }
        System.out.println(offsetDate);	
        
		System.out.println(df.getTimeZone());
		
//		System.out.println(DateTimeUtilities.getGregCalendarWithOffset(timeStamp, timezoneOffset, df));
		
//		SimpleDateFormat myFmt4=new SimpleDateFormat(
//                "一年中的第 D 天 一年中第w个星期 一月中第W个星期 在一天中k时 z时区");
//        Date now=new Date();
//        System.out.println(myFmt4.format(now));
	}
	public static GregorianCalendar getGregCalendar( String timestamp ) throws NumberFormatException {
//        if (timestamp == null || timestamp.trim().length() < 19){
//            return getGregCalendar();
//        }
        final int year = Integer.parseInt(timestamp.substring(0, 4));
        int month = Integer.parseInt(timestamp.substring(5, 7)) - 1;
        final int date = Integer.parseInt(timestamp.substring(8, 10));
        final int hour = Integer.parseInt(timestamp.substring(11, 13));
        final int min = Integer.parseInt(timestamp.substring(14, 16));
        final int sec = Integer.parseInt(timestamp.substring(17, 19));
        GregorianCalendar calendar = new GregorianCalendar(year, month, date, hour, min, sec);
        return calendar;
    }

}
