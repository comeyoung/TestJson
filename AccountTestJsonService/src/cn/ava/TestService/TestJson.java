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
		
		    //用Gson序列化json数据，并解析成Object,进行取值操作
			System.out.println("=========Gson解析=========");
			JsonParser parser = new JsonParser();
			JsonArray objArray = parser.parse(jsonData).getAsJsonArray();
			for (int i = 0; i < objArray.size(); i++) {
				Account account = new Gson().fromJson(objArray.get(i),
						Account.class);
				System.out.println("客户端流水号:" + account.getClientId());
				System.out.println("转账方式:" + account.getTransWay());
				System.out.println("用途:" + account.getPurpose());
				System.out.println("是否加急:" + account.getPriority());
			}
			
		/*业务处理:封装业务类，根据转账的同时对帐户的状态以及关联的各种信息进行CRUD操作，
			同时查询和处理还要返回的字段属性*/
			Status st = new Status();
			st.setRspCod("3102");
			st.setRspMsg("响应成功");
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
