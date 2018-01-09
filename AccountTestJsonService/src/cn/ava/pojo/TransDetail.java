package cn.ava.pojo;

public class TransDetail {
	/*
	 * "TransDetail" : [{ "ToAcct" : { "BankId" : "收款行联行号", "BankName" :
	 * "收款行名称", "AcctId" : "收款方账户号", "AcctName" : "收款方账户名称", "AcctType" :
	 * "收款人账户类型", }, "ReciepterIdType" : "收款人证件类型", "ReciepterIdCode" :
	 * "收款人证件号", "ReceipterType" : "收款人类型", "TransAmount" : "收款金额", "TransCur" :
	 * "收款币种", "SWIFTCode" : "收款行SWIFT编码", "Rate" : "参考汇率",
	 */
	private ToAcct toAcct;
	private String ReciepterIdType;
	private String ReciepterIdCode;
	private String ReceipterType;
	private Integer TransAmount;
	private String TransCur;
	private String SWIFTCode;
	private Double Rate;

	public ToAcct getToAcct() {
		return toAcct;
	}

	public void setToAcct(ToAcct toAcct) {
		this.toAcct = toAcct;
	}

	public String getReciepterIdType() {
		return ReciepterIdType;
	}

	public void setReciepterIdType(String reciepterIdType) {
		ReciepterIdType = reciepterIdType;
	}

	public String getReciepterIdCode() {
		return ReciepterIdCode;
	}

	public void setReciepterIdCode(String reciepterIdCode) {
		ReciepterIdCode = reciepterIdCode;
	}

	public String getReceipterType() {
		return ReceipterType;
	}

	public void setReceipterType(String receipterType) {
		ReceipterType = receipterType;
	}

	public Integer getTransAmount() {
		return TransAmount;
	}

	public void setTransAmount(Integer transAmount) {
		TransAmount = transAmount;
	}

	public String getTransCur() {
		return TransCur;
	}

	public void setTransCur(String transCur) {
		TransCur = transCur;
	}

	public String getSWIFTCode() {
		return SWIFTCode;
	}

	public void setSWIFTCode(String sWIFTCode) {
		SWIFTCode = sWIFTCode;
	}

	public Double getRate() {
		return Rate;
	}

	public void setRate(Double rate) {
		Rate = rate;
	}

	public TransDetail(ToAcct toAcct, String reciepterIdType,
			String reciepterIdCode, String receipterType, Integer transAmount,
			String transCur, String sWIFTCode, Double rate) {
		super();
		this.toAcct = toAcct;
		ReciepterIdType = reciepterIdType;
		ReciepterIdCode = reciepterIdCode;
		ReceipterType = receipterType;
		TransAmount = transAmount;
		TransCur = transCur;
		SWIFTCode = sWIFTCode;
		Rate = rate;
	}

	public TransDetail() {
		super();
	}

	@Override
	public String toString() {
		return "TransDetail [toAcct=" + toAcct + ", ReciepterIdType="
				+ ReciepterIdType + ", ReciepterIdCode=" + ReciepterIdCode
				+ ", ReceipterType=" + ReceipterType + ", TransAmount="
				+ TransAmount + ", TransCur=" + TransCur + ", SWIFTCode="
				+ SWIFTCode + ", Rate=" + Rate + "]";
	}

}
