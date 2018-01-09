package cn.ava.pojo;

public class ToAcct {
	/*
	 * "BankId" : "收款行联行号", "BankName" : "收款行名称", "AcctId" : "收款方账户号",
	 * "AcctName" : "收款方账户名称", "AcctType" : "收款人账户类型",
	 */
	private String BankId;
	private String BankName;
	private String AcctId;
	private String AcctName;
	private String AcctType;

	public String getBankId() {
		return BankId;
	}

	public void setBankId(String bankId) {
		BankId = bankId;
	}

	public String getBankName() {
		return BankName;
	}

	public void setBankName(String bankName) {
		BankName = bankName;
	}

	public String getAcctId() {
		return AcctId;
	}

	public void setAcctId(String acctId) {
		AcctId = acctId;
	}

	public String getAcctName() {
		return AcctName;
	}

	public void setAcctName(String acctName) {
		AcctName = acctName;
	}

	public String getAcctType() {
		return AcctType;
	}

	public void setAcctType(String acctType) {
		AcctType = acctType;
	}

	public ToAcct(String bankId, String bankName, String acctId,
			String acctName, String acctType) {
		super();
		BankId = bankId;
		BankName = bankName;
		AcctId = acctId;
		AcctName = acctName;
		AcctType = acctType;
	}

	public ToAcct() {
		super();
	}

	@Override
	public String toString() {
		return "ToAcct [BankId=" + BankId + ", BankName=" + BankName
				+ ", AcctId=" + AcctId + ", AcctName=" + AcctName
				+ ", AcctType=" + AcctType + "]";
	}

}
