package cn.ava.TestService;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

import cn.ava.pojo.Account;
import cn.ava.pojo.AccountResponse;
import cn.ava.pojo.FromAcct;
import cn.ava.pojo.Response;
import cn.ava.pojo.Status;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@WebService
public class TestJson {
	public String TestJsonFirst(String jsonData) {
		
		    //��Gson���л�json���ݣ���������Object,����ȡֵ����
			System.out.println("=========Gson����=========");
			JsonParser parser = new JsonParser();
			JsonArray objArray = parser.parse(jsonData).getAsJsonArray();
			for (int i = 0; i < objArray.size(); i++) {
				Account account = new Gson().fromJson(objArray.get(i),
						Account.class);
				System.out.println("�ͻ�����ˮ��:" + account.getClientId());
				System.out.println("ת�˷�ʽ:" + account.getTransWay());
				System.out.println("��;:" + account.getPurpose());
				System.out.println("�Ƿ�Ӽ�:" + account.getPriority());
			}
			
		/*ҵ����:��װҵ���࣬����ת�˵�ͬʱ���ʻ���״̬�Լ������ĸ�����Ϣ����CRUD������
			ͬʱ��ѯ�ʹ���Ҫ���ص��ֶ�����*/
			Status st = new Status();
			st.setRspCod("3102");
			st.setRspMsg("��Ӧ�ɹ�");
			Response re = new Response();
			re.setStatus(st);
			List<Response> relist = new ArrayList<Response>();
			relist.add(re);
			AccountResponse ar = new AccountResponse();
			ar.setResponselist(relist);
			ar.setClientId(12);
			ar.setInsId(23);
			ar.setObssId(34);
			String resMsg = new Gson().toJson(ar);
			return resMsg;
		}
	

	public static void main(String[] args) {

		Endpoint.publish("http://localhost:1123/Service/TestJson",
				new TestJson());
		System.out.println("sueecss");

	}

}
