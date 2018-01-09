package cn.ava.pojo;

public class FromAcct {
	/*
	 * "BankId" : "付款行联行号", "BankName" : "付款行名称", "AccountId" : "付款账户号",
	 * "AcctName" : "付款账户名称",
	 */
	private String BankId;
	private String BankName;
	private String AccountId;
	private String AcctName;

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

	public String getAccountId() {
		return AccountId;
	}

	public void setAccountId(String accountId) {
		AccountId = accountId;
	}

	public String getAcctName() {
		return AcctName;
	}

	public void setAcctName(String acctName) {
		AcctName = acctName;
	}

	public FromAcct(String bankId, String bankName, String accountId,
			String acctName) {
		super();
		BankId = bankId;
		BankName = bankName;
		AccountId = accountId;
		AcctName = acctName;
	}

	public FromAcct() {
		super();
	}

	@Override
	public String toString() {
		return "FromAcct [BankId=" + BankId + ", BankName=" + BankName
				+ ", AccountId=" + AccountId + ", AcctName=" + AcctName + "]";
	}

}
