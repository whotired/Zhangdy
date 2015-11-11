package test.zhangdy.interview;

public class SwitchTest {

	public enum Day {
	    SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
	    THURSDAY, FRIDAY, SATURDAY 
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//switch can work with byte,short,char,int, enum type, Byte,Character,Short,Integer
		//can not work with long, String(for 1.6)
		
		//switch - int
		int month = 8;
        String monthString;
        switch (month) {
            case 1:  monthString = "January";
                     break;
            case 2:  monthString = "February";
                     break;
            case 3:  monthString = "March";
                     break;
            case 4:  monthString = "April";
                     break;
            case 5:  monthString = "May";
                     break;
            case 6:  monthString = "June";
                     break;
            case 7:  monthString = "July";
                     break;
            case 8:  monthString = "August";
                     break;
            case 9:  monthString = "September";
                     break;
            case 10: monthString = "October";
                     break;
            case 11: monthString = "November";
                     break;
            case 12: monthString = "December";
                     break;
            default: monthString = "Invalid month";
                     break;
        }
        System.out.println(monthString);
        
        //switch - enum type
        Day day = Day.FRIDAY;
        switch (day) {
        case MONDAY:
            System.out.println("Mondays are bad.");
            break;
                
        case FRIDAY:
            System.out.println("Fridays are better.");
            break;
                     
        case SATURDAY: case SUNDAY:
            System.out.println("Weekends are best.");
            break;
                    
        default:
            System.out.println("Midweek days are so-so.");
            break;
        }
        
        Character ch = new Character('a');
        switch( ch ){
        case 'a':
        	System.out.println(ch.charValue());
        	break;
        case 'b':
        	System.out.println(ch.charValue());
        	break;
        default:
        	System.out.println(ch.charValue());
        	break;
        }
        // switch can work with String only for 1.7
//        switch (month.toLowerCase()) {
//            case "january":
//                monthNumber = 1;
//                break;
//            case "february":
//                monthNumber = 2;
//                break;
//            case "march":
//                monthNumber = 3;
//                break;
//            case "april":
//                monthNumber = 4;
//                break;
//            case "may":
//                monthNumber = 5;
//                break;
//            case "june":
//                monthNumber = 6;
//                break;
//            case "july":
//                monthNumber = 7;
//                break;
//            case "august":
//                monthNumber = 8;
//                break;
//            case "september":
//                monthNumber = 9;
//                break;
//            case "october":
//                monthNumber = 10;
//                break;
//            case "november":
//                monthNumber = 11;
//                break;
//            case "december":
//                monthNumber = 12;
//                break;
//            default: 
//                monthNumber = 0;
//                break;
//        }

	}

}
