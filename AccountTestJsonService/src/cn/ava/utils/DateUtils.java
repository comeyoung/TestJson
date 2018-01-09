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
	    public static final String ERROR = "error";//��Ϊ��ʾ��
	    public static final String RIGHT = "right";//��ȷ����
	    public static final String ERRORMESSAGE = "errorMessage";
	    public static final String STOP = "stop";//������ר��
	    public static final String TOTELSALE = "toTelSale";//��Ҫת����
	    public static final String EXCEPTION = "exception";//ϵͳ�쳣
	    
	    
	   
	    
	    
	    

	   
	    
		/**
		 * ��ȸ���,������������ͼ
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
		 * ��ȡxml�ĵ�
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
		 * ��ȡ��ǰӦ�÷�����IP
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
		 * ���ֽ���дת����˼����д��������Ȼ������ʰ�滻����
		 * 
		 * Ҫ�õ�������ʽ
		 */

		public static String digitUppercase(double n) {

			String fraction[] = { "��", "��" };

			String digit[] = { "��", "Ҽ", "��", "��", "��", "��", "½", "��", "��", "��" };

			String unit[][] = { { "Ԫ", "��", "��" },

			{ "", "ʰ", "��", "Ǫ" } };

			String head = n < 0 ? "��" : "";

			n = Math.abs(n);

			String s = "";

			for (int i = 0; i < fraction.length; i++) {

				s += (digit[(int) (Math.floor(n * 10 * Math.pow(10, i)) % 10)] + fraction[i])
						.replaceAll("(��.)+", "");

			}

			if (s.length() < 1) {

				s = "��";

			}

			int integerPart = (int) Math.floor(n);

			for (int i = 0; i < unit[0].length && integerPart > 0; i++) {

				String p = "";

				for (int j = 0; j < unit[1].length && n > 0; j++) {

					p = digit[integerPart % 10] + unit[1][j] + p;

					integerPart = integerPart / 10;

				}

				s = p.replaceAll("(��.)*��$", "").replaceAll("^$", "��") + unit[0][i]
						+ s;

			}

			return head
					+ s.replaceAll("(��.)*��Ԫ", "Ԫ").replaceFirst("(��.)+", "")
							.replaceAll("(��.)+", "��").replaceAll("^��$", "��Ԫ��");

		}
		
		/**
		 * ������ת��Ϊ��д�磺����һ����һ��һ��
		 * @param date
		 */
		public static String turnDate(Date date){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String date_s = sdf.format(date);
			String[] args = date_s.split("-");
			String ret = turnYear(args[0])+
					turnMonthAndDay(args[1])+"��"+turnMonthAndDay(args[2])+"��";
			return ret;
		}
		
		private static String turnYear(String year){
			String ret = "";
			for(char c : year.toCharArray()){
				switch(c){
				case '1' : ret += "һ";break;
				case '2' : ret += "��";break;
				case '3' : ret += "��";break;
				case '4' : ret += "��";break;
				case '5' : ret += "��";break;
				case '6' : ret += "��";break;
				case '7' : ret += "��";break;
				case '8' : ret += "��";break;
				case '9' : ret += "��";break;
				case '0' : ret += "��";break;
				default : ret += "��";
				}
			}
			ret += "��";
			return ret;
		}
		private static String turnMonthAndDay(String s){
			String ret = "";
			char[] chars = s.toCharArray();
			switch(chars[0]){
			case '1' : ret += "ʮ";break;
			case '2' : ret += "��ʮ";break;
			case '3' : ret += "��ʮ";break;
			case '0' : ret += "";break;
			default : ret += "";
			}
			switch(chars[1]){
			case '1' : ret += "һ";break;
			case '2' : ret += "��";break;
			case '3' : ret += "��";break;
			case '4' : ret += "��";break;
			case '5' : ret += "��";break;
			case '6' : ret += "��";break;
			case '7' : ret += "��";break;
			case '8' : ret += "��";break;
			case '9' : ret += "��";break;
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
