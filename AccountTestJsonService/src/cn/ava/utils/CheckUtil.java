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
     * �ж��û�����ʽ�Ƿ���ȷ
     * @param string
     * @return
     *      ��ȷ����true��
     */
    public boolean isUserId(String string){
    	pattern = Pattern.compile("[a-zA-Z_0-9]{5,20}");
        matcher=pattern.matcher(string);
        return matcher.matches();
    }
    /**
     * �ж϶����Ƿ�Ϊ��
     * @param object
     * @return
     *     �շ���true
     */
    public boolean isEmpty(Object object){
        if(object==null||"".equals(object)){
            return true;
        }
        return false;
    }
    /**
     * �ж��ַ����Ƿ�Ϊ��Ӣ���ַ�
     * @param string
     * @return
     *      ���Ϸ���true�������Ϸ���false
     */
    public boolean isCnOrEn(String string){
        pattern = Pattern.compile("^[\u0391-\uFFE5a-zA-Z��.��]*$");
        matcher=pattern.matcher(string);
        return matcher.matches();
    }
    
    
    /**
     * �ж����֤���Ƿ�Ϸ�
     * @param string
     * @return
     *       �Ϸ�����true�����򷵻�false
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
     * �ж�֤�������Ƿ�Ϸ�
     * @param string
     * @return
     *       �Ϸ�����true�����򷵻�false
     */    
    public boolean isCard(String string){
        pattern = Pattern.compile("^[a-zA-Z0-9]+$");
        matcher=pattern.matcher(string);
        return matcher.matches();
    }
    
    /**
     * �ж��Ƿ�Ϊ�ʱ�
     * @param string
     * @return
     *      Ϊ�ʱ෵��true�����򷵻�false
     */
    public boolean isZipCode(String string){
        pattern =Pattern.compile("^\\d{6}$");
        matcher=pattern.matcher(string);
        return matcher.matches();
    }
    
    /**
     * �ж��ƶ��绰�����ʽ�Ƿ���ȷ
     * @param string
     * @return
     *      ��ȷ����true��
     */
    public boolean isMobilNum(String string){
        pattern =Pattern.compile("^[1][3-8]+\\d{9}");
        matcher=pattern.matcher(string);
        return matcher.matches();
    }
    
    /**
     * �ж������ʽ�Ƿ���ȷ
     * @param string
     * @return
     *      ��ȷ����true
     */
    public boolean isEmail(String string){
        pattern = Pattern.compile("(^(\\w)+(.\\w+)*@(\\w)+((\\.\\w+)+)$)");
        matcher=pattern.matcher(string);
        return matcher.matches();
    }
    /**
     * ȡ��ָ�������Ժ�����������ڡ����Ҫ�õ���ǰ�����ڣ������ø�����
     * 
     * @param date ��׼����
     * @param days ���ӵ�������
     * @return �����Ժ������
     */
    public Date addDays(Date date, int days) {
        return add(date, days, Calendar.DATE);
    }
    /**
     * ȡ��ָ�������Ժ������µ����ڡ����Ҫ�õ���ǰ�����ڣ������ø�����
     * 
     * @param date ��׼����
     * @param months ���ӵ�������
     * @return �����Ժ������
     */
    public Date addMonths(Date date, int months){
        return add(date, months, Calendar.MONTH);
    }
    /**
     * ȡ��ָ�������Ժ�����������ڡ����Ҫ�õ���ǰ�����ڣ������ø�����
     * 
     * @param date ��׼����
     * @param years ���ӵ�������
     * @return �����Ժ������
     */
    public Date addYears(Date date, int years){
        return add(date, years, Calendar.YEAR);
    }
    /**
     * �ڲ�������Ϊָ������������Ӧ������������
     * 
     * @param date ��׼����
     * @param amount ���ӵ�����
     * @param field ���ӵĵ�λ���꣬�»�����
     * @return �����Ժ������
     */
    private static Date add(Date date, int amount, int field) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(field, amount);
        return calendar.getTime();
    }

    /**
     * �ж����ڸ�ʽ�Ƿ���ȷ
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
            // ��ʽ����
            return false;
        }
    }
    /**
     * �ó����Ƿ�Ϊ����
     * @param modelName
     * @return
     * ��������true 
     */
    public boolean isTruck(String modelName){
    	pattern = Pattern.compile("^[\u4E00-\u9FA5a-zA-Z -]*([267]+|\\d{1}\\.|$).*$");
    	matcher = pattern.matcher(modelName);
    	return !matcher.matches();
    }

    /** 
     * �������֤���� ���س�������
     * @param �������18λ���֤���� 
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
            throw new Exception("���֤���Ϸ���");  
        }
		return birthDay;
    }
    
    /** 
     * ����15λ�����֤������18λ���֤���� 
     * @param fifteenIDCard 15λ�����֤���� 
     * @return �������18λ���֤���� 
     * @throws Exception �������15λ�����֤���룬���׳��쳣 
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
            throw new Exception("����15λ�����֤");  
        }  
    }  
      
    /** 
     * ��ȡУ���� 
     * @param idCardNumber ����У��λ�����֤���루17λ�� 
     * @return У���� 
     * @throws Exception ������֤û�м���19�����׳��쳣 
     */  
    public static  char getVerifyCode(String idCardNumber) throws Exception{  
        if(idCardNumber == null || idCardNumber.length() < 17) {  
            throw new Exception("���Ϸ������֤����");  
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
     * У��18λ�����֤�����У��λ�Ƿ���ȷ 
     * @param idCardNumber 18λ�����֤���� 
     * @return  
     * @throws Exception 
     */  
    public static boolean verify(String idCardNumber) throws Exception{  
        if(idCardNumber == null || idCardNumber.length() != 18) {  
            throw new Exception("����18λ�����֤����");  
        }  
        return getVerifyCode(idCardNumber) == idCardNumber.charAt(idCardNumber.length() - 1);  
    }  

}
