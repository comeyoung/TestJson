package cn.ava.pojo;

public class Status {
	/*"status" : {
	"RspCod" : "��Ӧ��",
	"RspMsg" : "��Ӧ��Ϣ"
                       }*/
	private String RspCod;
	private String RspMsg;
	public String getRspCod() {
		return RspCod;
	}
	public void setRspCod(String rspCod) {
		RspCod = rspCod;
	}
	public String getRspMsg() {
		return RspMsg;
	}
	public void setRspMsg(String rspMsg) {
		RspMsg = rspMsg;
	}
	public Status(String rspCod, String rspMsg) {
		super();
		RspCod = rspCod;
		RspMsg = rspMsg;
	}
	public Status() {
		super();
	}
	@Override
	public String toString() {
		return "Status [RspCod=" + RspCod + ", RspMsg=" + RspMsg + "]";
	}
	

}
