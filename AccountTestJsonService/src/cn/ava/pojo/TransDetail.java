package cn.ava.pojo;

public class TransDetail {
	/*
	 * "TransDetail" : [{ "ToAcct" : { "BankId" : "�տ������к�", "BankName" :
	 * "�տ�������", "AcctId" : "�տ�˻���", "AcctName" : "�տ�˻�����", "AcctType" :
	 * "�տ����˻�����", }, "ReciepterIdType" : "�տ���֤������", "ReciepterIdCode" :
	 * "�տ���֤����", "ReceipterType" : "�տ�������", "TransAmount" : "�տ���", "TransCur" :
	 * "�տ����", "SWIFTCode" : "�տ���SWIFT����", "Rate" : "�ο�����",
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
