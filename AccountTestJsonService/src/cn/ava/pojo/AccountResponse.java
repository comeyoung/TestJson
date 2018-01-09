package cn.ava.pojo;

import java.util.List;

public class AccountResponse {
/*	{	
		"response" : [{
				"status" : {
					"RspCod" : "",
					"RspMsg" : ""
	                                   }
	                     }],
			"ClientId" : "客户端流水号",
			"InsId" : "转账指令ID",
			"ObssId" : "网银交易流水号"
			}
*/
	private List<Response> responselist;
	private Integer ClientId;
	private Integer InsId;
	private Integer ObssId;
	
	public List<Response> getResponselist() {
		return responselist;
	}
	public void setResponselist(List<Response> responselist) {
		this.responselist = responselist;
	}
	public Integer getClientId() {
		return ClientId;
	}
	public void setClientId(Integer clientId) {
		ClientId = clientId;
	}
	public Integer getInsId() {
		return InsId;
	}
	public void setInsId(Integer insId) {
		InsId = insId;
	}
	public Integer getObssId() {
		return ObssId;
	}
	public void setObssId(Integer obssId) {
		ObssId = obssId;
	}
	
	public AccountResponse(List<Response> responselist, Integer clientId,
			Integer insId, Integer obssId) {
		super();
		this.responselist = responselist;
		ClientId = clientId;
		InsId = insId;
		ObssId = obssId;
	}
	public AccountResponse() {
		super();
	}
	@Override
	public String toString() {
		return "AccountResponse [responselist=" + responselist + ", ClientId="
				+ ClientId + ", InsId=" + InsId + ", ObssId=" + ObssId + "]";
	}
	
	
	
	
}
