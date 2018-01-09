package cn.ava.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckUtil {
	Pattern pattern=null;
    Matcher matcher=null;
    
    /**
     * 判断用户名格式是否正确
     * @param string
     * @return
     *      正确返回true；
     */
    public boolean isUserId(String string){
    	pattern = Pattern.compile("[a-zA-Z_0-9]{5,20}");
        matcher=pattern.matcher(string);
        return matcher.matches();
    }
    /**
     * 判断对象是否为空
     * @param object
     * @return
     *     空返回true
     */
    public boolean isEmpty(Object object){
        if(object==null||"".equals(object)){
            return true;
        }
        return false;
    }
    /**
     * 判断字符串是否都为中英文字符
     * @param string
     * @return
     *      符合返回true，不符合返回false
     */
    public boolean isCnOrEn(String string){
        pattern = Pattern.compile("^[\u0391-\uFFE5a-zA-Z·.。]*$");
        matcher=pattern.matcher(string);
        return matcher.matches();
    }
    
    
    /**
     * 判断身份证号是否合法
     * @param string
     * @return
     *       合法返回true，否则返回false
     */    
    public boolean isIDCard(String string){
        if(string.indexOf("X") != -1){
            string = string.replace("X", "x");
        }
        pattern = Pattern.compile("^\\d{15}|\\d{17}(\\d{1}|x)$");
        matcher=pattern.matcher(string);
        return matcher.matches();
    }
    
    /**
     * 判断证件号码是否合法
     * @param string
     * @return
     *       合法返回true，否则返回false
     */    
    public boolean isCard(String string){
        pattern = Pattern.compile("^[a-zA-Z0-9]+$");
        matcher=pattern.matcher(string);
        return matcher.matches();
    }
    
    /**
     * 判断是否为邮编
     * @param string
     * @return
     *      为邮编返回true，否则返回false
     */
    public boolean isZipCode(String string){
        pattern =Pattern.compile("^\\d{6}$");
        matcher=pattern.matcher(string);
        return matcher.matches();
    }
    
    /**
     * 判断移动电话号码格式是否正确
     * @param string
     * @return
     *      正确返回true；
     */
    public boolean isMobilNum(String string){
        pattern =Pattern.compile("^[1][3-8]+\\d{9}");
        matcher=pattern.matcher(string);
        return matcher.matches();
    }
    
    /**
     * 判断邮箱格式是否正确
     * @param string
     * @return
     *      正确返回true
     */
    public boolean isEmail(String string){
        pattern = Pattern.compile("(^(\\w)+(.\\w+)*@(\\w)+((\\.\\w+)+)$)");
        matcher=pattern.matcher(string);
        return matcher.matches();
    }
    /**
     * 取得指定日期以后若干天的日期。如果要得到以前的日期，参数用负数。
     * 
     * @param date 基准日期
     * @param days 增加的日期数
     * @return 增加以后的日期
     */
    public Date addDays(Date date, int days) {
        return add(date, days, Calendar.DATE);
    }
    /**
     * 取得指定日期以后若干月的日期。如果要得到以前的日期，参数用负数。
     * 
     * @param date 基准日期
     * @param months 增加的日期数
     * @return 增加以后的日期
     */
    public Date addMonths(Date date, int months){
        return add(date, months, Calendar.MONTH);
    }
    /**
     * 取得指定日期以后若干年的日期。如果要得到以前的日期，参数用负数。
     * 
     * @param date 基准日期
     * @param years 增加的日期数
     * @return 增加以后的日期
     */
    public Date addYears(Date date, int years){
        return add(date, years, Calendar.YEAR);
    }
    /**
     * 内部方法。为指定日期增加相应的天数或月数
     * 
     * @param date 基准日期
     * @param amount 增加的数量
     * @param field 增加的单位，年，月或者日
     * @return 增加以后的日期
     */
    private static Date add(Date date, int amount, int field) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(field, amount);
        return calendar.getTime();
    }

    /**
     * 判断日期格式是否正确
     * 
     * @param strDate
     * @return
     */
    public boolean isValidDate(String strDate) {
        SimpleDateFormat  dateFormat = new SimpleDateFormat("yyyyMMdd");
        if (strDate == null) return false;
        strDate.replaceAll("/", "");
        strDate.replaceAll("-", "");        
        try {
            dateFormat.parse(strDate);
            return true;
        } catch (Exception e) {
            // 格式不对
            return false;
        }
    }
    /**
     * 该车型是否为货车
     * @param modelName
     * @return
     * 货车返回true 
     */
    public boolean isTruck(String modelName){
    	pattern = Pattern.compile("^[\u4E00-\u9FA5a-zA-Z -]*([267]+|\\d{1}\\.|$).*$");
    	matcher = pattern.matcher(modelName);
    	return !matcher.matches();
    }

    /** 
     * 根据身份证号码 返回出生日期
     * @param 升级后的18位身份证号码 
     */  
    public static String getBirthDayFromIDCard(String number) throws Exception{
    	String birthDay = "";
        if(number != null && !"".equals(number)){
        	if(18==number.length()){
        		String year = number.substring(6, 10);
        		String month = number.substring(10, 12);
        		String day = number.substring(12, 14);
        		birthDay = year+"/"+month+"/"+day;
        		return birthDay;
        	}else if(15==number.length()){
        	    String numberNew = getEighteenIDCard(number);
        	    String year1 = numberNew.substring(6, 10);
        		String month1 = numberNew.substring(10, 12);
        		String day1 = numberNew.substring(12, 14);
        		birthDay = year1+"/"+month1+"/"+day1;
        		return birthDay;
        } 
        }else {  
            throw new Exception("身份证不合法！");  
        }
		return birthDay;
    }
    
    /** 
     * 根据15位的身份证号码获得18位身份证号码 
     * @param fifteenIDCard 15位的身份证号码 
     * @return 升级后的18位身份证号码 
     * @throws Exception 如果不是15位的身份证号码，则抛出异常 
     */  
    private static String getEighteenIDCard(String fifteenIDCard) throws Exception{  
        if(fifteenIDCard != null && fifteenIDCard.length() == 15){  
            StringBuilder sb = new StringBuilder();  
            sb.append(fifteenIDCard.substring(0, 6))  
              .append("19")  
              .append(fifteenIDCard.substring(6));  
            sb.append(getVerifyCode(sb.toString()));  
            return sb.toString();  
        } else {  
            throw new Exception("不是15位的身份证");  
        }  
    }  
      
    /** 
     * 获取校验码 
     * @param idCardNumber 不带校验位的身份证号码（17位） 
     * @return 校验码 
     * @throws Exception 如果身份证没有加上19，则抛出异常 
     */  
    public static  char getVerifyCode(String idCardNumber) throws Exception{  
        if(idCardNumber == null || idCardNumber.length() < 17) {  
            throw new Exception("不合法的身份证号码");  
        }  
        char[] Ai = idCardNumber.toCharArray();  
        int[] Wi = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};  
        char[] verifyCode = {'1','0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};  
        int S = 0;  
        int Y;  
        for(int i = 0; i < Wi.length; i++){  
            S += (Ai[i] - '0') * Wi[i];  
        }  
        Y = S % 11;  
        return verifyCode[Y];  
    }  
      
    /** 
     * 校验18位的身份证号码的校验位是否正确 
     * @param idCardNumber 18位的身份证号码 
     * @return  
     * @throws Exception 
     */  
    public static boolean verify(String idCardNumber) throws Exception{  
        if(idCardNumber == null || idCardNumber.length() != 18) {  
            throw new Exception("不是18位的身份证号码");  
        }  
        return getVerifyCode(idCardNumber) == idCardNumber.charAt(idCardNumber.length() - 1);  
    }  

}
