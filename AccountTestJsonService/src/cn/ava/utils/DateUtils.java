package cn.ava.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.Random;

import org.w3c.dom.DOMException;

import com.sun.xml.txw2.Document;

public class DateUtils {
	 public static final String DateStyle = "yyyy-MM-dd";
	    public static final String MESSAGETYPE = "messageType";
	    public static final String INPUTERROR = "inputError";
	    public static final String ERROR = "error";//作为提示用
	    public static final String RIGHT = "right";//正确流程
	    public static final String ERRORMESSAGE = "errorMessage";
	    public static final String STOP = "stop";//过户车专用
	    public static final String TOTELSALE = "toTelSale";//需要转电销
	    public static final String EXCEPTION = "exception";//系统异常
	    
	    
	   
	    
	    
	    

	   
	    
		/**
		 * 深度复制,复制整个对象图
		 */
		public static Serializable deeplyCopy(Serializable src){
			try {
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(baos);
				oos.writeObject(src);
				oos.close();
				baos.close();
				
				byte[] bytes = baos.toByteArray();
				
				ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
				ObjectInputStream ois = new ObjectInputStream(bais);
				Serializable copy = (Serializable) ois.readObject();
				ois.close();
				bais.close();
				return copy ;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null ;
		}
		
		/**
		 * 获取xml文档
		 * @param content
		 * @return
		 */
	/*	public static Document getReader(String content) {
			Document document = null;
			try {
				SAXReader reader = new SAXReader();
				StringReader stringReader = new StringReader(content.trim());
				document = reader.read(stringReader);
			} catch (DOMException e1) {
				return null;
			}
			return document;
		}*/

	
		/**
		 * 获取当前应用服务器IP
		 * @return
		 */
		public static String getLocalIP() {
			try {
				InetAddress address = InetAddress.getLocalHost();
				return address.getHostAddress().toString();
			} catch (UnknownHostException e) {
				e.printStackTrace();
				return null;
			}
		}
		
		
		
		/**
		 * 
		 * 数字金额大写转换，思想先写个完整的然后将如零拾替换成零
		 * 
		 * 要用到正则表达式
		 */

		public static String digitUppercase(double n) {

			String fraction[] = { "角", "分" };

			String digit[] = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };

			String unit[][] = { { "元", "万", "亿" },

			{ "", "拾", "佰", "仟" } };

			String head = n < 0 ? "负" : "";

			n = Math.abs(n);

			String s = "";

			for (int i = 0; i < fraction.length; i++) {

				s += (digit[(int) (Math.floor(n * 10 * Math.pow(10, i)) % 10)] + fraction[i])
						.replaceAll("(零.)+", "");

			}

			if (s.length() < 1) {

				s = "整";

			}

			int integerPart = (int) Math.floor(n);

			for (int i = 0; i < unit[0].length && integerPart > 0; i++) {

				String p = "";

				for (int j = 0; j < unit[1].length && n > 0; j++) {

					p = digit[integerPart % 10] + unit[1][j] + p;

					integerPart = integerPart / 10;

				}

				s = p.replaceAll("(零.)*零$", "").replaceAll("^$", "零") + unit[0][i]
						+ s;

			}

			return head
					+ s.replaceAll("(零.)*零元", "元").replaceFirst("(零.)+", "")
							.replaceAll("(零.)+", "零").replaceAll("^整$", "零元整");

		}
		
		/**
		 * 将日期转换为大写如：二零一四年一月一日
		 * @param date
		 */
		public static String turnDate(Date date){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String date_s = sdf.format(date);
			String[] args = date_s.split("-");
			String ret = turnYear(args[0])+
					turnMonthAndDay(args[1])+"月"+turnMonthAndDay(args[2])+"日";
			return ret;
		}
		
		private static String turnYear(String year){
			String ret = "";
			for(char c : year.toCharArray()){
				switch(c){
				case '1' : ret += "一";break;
				case '2' : ret += "二";break;
				case '3' : ret += "三";break;
				case '4' : ret += "四";break;
				case '5' : ret += "五";break;
				case '6' : ret += "六";break;
				case '7' : ret += "七";break;
				case '8' : ret += "八";break;
				case '9' : ret += "九";break;
				case '0' : ret += "零";break;
				default : ret += "零";
				}
			}
			ret += "年";
			return ret;
		}
		private static String turnMonthAndDay(String s){
			String ret = "";
			char[] chars = s.toCharArray();
			switch(chars[0]){
			case '1' : ret += "十";break;
			case '2' : ret += "二十";break;
			case '3' : ret += "三十";break;
			case '0' : ret += "";break;
			default : ret += "";
			}
			switch(chars[1]){
			case '1' : ret += "一";break;
			case '2' : ret += "二";break;
			case '3' : ret += "三";break;
			case '4' : ret += "四";break;
			case '5' : ret += "五";break;
			case '6' : ret += "六";break;
			case '7' : ret += "七";break;
			case '8' : ret += "八";break;
			case '9' : ret += "九";break;
			case '0' : ret += "";break;
			default : ret += "";
			}
			return ret;
		}
		
		
		public static String buildValidateCode() {
			String s = "0123456789";
			String word = "abcdefghijklmnopqrstuvwxyz";
			String str = s+word+word.toUpperCase();
			Random r = new Random();
			StringBuilder sb = new StringBuilder();
			sb.append(String.valueOf(str.charAt(r.nextInt(str.length()))));
			sb.append(String.valueOf(str.charAt(r.nextInt(str.length()))));
			sb.append(String.valueOf(str.charAt(r.nextInt(str.length()))));
			sb.append(String.valueOf(str.charAt(r.nextInt(str.length()))));
			sb.append(String.valueOf(str.charAt(r.nextInt(str.length()))));
			sb.append(String.valueOf(str.charAt(r.nextInt(str.length()))));
			return sb.toString();
		}

}
