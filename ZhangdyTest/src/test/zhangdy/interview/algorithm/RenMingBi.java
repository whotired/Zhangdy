package test.zhangdy.interview.algorithm;

/**
 * 12．金额转换，阿拉伯数字的金额转换成中国传统的形式如：（￥1011）－>（一千零一拾一元整）输出。
去零的代码：
    return sb.reverse().toString().replaceAll("零[拾佰仟]","零").replaceAll("零+万","万")
    .replaceAll("零+元","元").replaceAll("零+","零");
    
 * @author esw
 *
 */
public class RenMingBi {
	 
    /**
     * @param args add by zxx ,Nov 29, 2008
     */
    private static final char[] data = new char[]{
                  '零','壹','贰','叁','肆','伍','陆','柒','捌','玖'
           };
    private static final char[] units = new char[]{
           '元','拾','佰','仟','万','拾','佰','仟','亿'
    };
    public static void main(String[] args) {
           // TODOAuto-generated method stub
           System.out.println( convert(135689123));
           /*
            * result:
            * 	壹亿叁仟伍佰陆拾捌万玖仟壹佰贰拾叁元
            */
           System.out.println( convert(130008120));
           /*
            * result:
            * 	壹亿叁仟万捌仟壹佰贰拾元
            */
    }

    public static String convert(int money)
    {
           StringBuffer sbf = new StringBuffer();
           int unit = 0;
           while(money!=0)
           {
                  sbf.insert(0,units[unit++]);
                  int number = money%10;
                  sbf.insert(0,data[number]);
                  money/= 10;
           }

//           return sbf.toString();
           return sbf.toString().replaceAll("零[拾佰仟]","零").replaceAll("零+万","万")
        		    .replaceAll("零+元","元").replaceAll("零+","零");
    }
}
