package cn.ava.pojo;

public class Response {
/*	{
		"response" : [{
				"status" : {
					"RspCod" : "",
					"RspMsg" : ""
	                                   }
	                     }]
*/
	private Status status;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Response(Status status) {
		super();
		this.status = status;
	}

	public Response() {
		super();
	}

	@Override
	public String toString() {
		return "Response [status=" + status + "]";
	}
	
}
