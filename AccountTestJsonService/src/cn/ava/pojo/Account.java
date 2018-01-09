package cn.ava.pojo;

import java.util.List;

public class Account {
	/*
	 * "ClientId" : "客户端流水号", "TransWay" : "转账方式", "BusinessType" : "转账业务类型",
	 * "PaymentCur" : "付款币种", "PaymentType" : "支付类型", "Purpose" : "用途",
	 * "Priority" : "是否加急", "TransDate" : "交易日期", "TransTime" : "交易时间",
	 * "FeeType" : "收费类型", "FeeAcct" : "手续费账号", "AgentSign" : "代收代付标志",
	 * "Comments" : "备注/附言", "FromAcct" : {}, "TransDetail" : []
	 */
	private Integer ClientId;
	private String TransWay;
	private String BusinessType;
	private String PaymentCur;
	private String PaymentType;
	private String Purpose;
	private String Priority;
	private String TransDate;
	private String TransTime;
	private String FeeType;
	private String FeeAcct;
	private String AgentSign;
	private String Comments;
	private FromAcct fromAcct;
	private List<TransDetail> transDetails;
	public Integer getClientId() {
		return ClientId;
	}
	public void setClientId(Integer clientId) {
		ClientId = clientId;
	}
	public String getTransWay() {
		return TransWay;
	}
	public void setTransWay(String transWay) {
		TransWay = transWay;
	}
	public String getBusinessType() {
		return BusinessType;
	}
	public void setBusinessType(String businessType) {
		BusinessType = businessType;
	}
	public String getPaymentCur() {
		return PaymentCur;
	}
	public void setPaymentCur(String paymentCur) {
		PaymentCur = paymentCur;
	}
	public String getPaymentType() {
		return PaymentType;
	}
	public void setPaymentType(String paymentType) {
		PaymentType = paymentType;
	}
	public String getPurpose() {
		return Purpose;
	}
	public void setPurpose(String purpose) {
		Purpose = purpose;
	}
	public String getPriority() {
		return Priority;
	}
	public void setPriority(String priority) {
		Priority = priority;
	}
	public String getTransDate() {
		return TransDate;
	}
	public void setTransDate(String transDate) {
		TransDate = transDate;
	}
	public String getTransTime() {
		return TransTime;
	}
	public void setTransTime(String transTime) {
		TransTime = transTime;
	}
	public String getFeeType() {
		return FeeType;
	}
	public void setFeeType(String feeType) {
		FeeType = feeType;
	}
	public String getFeeAcct() {
		return FeeAcct;
	}
	public void setFeeAcct(String feeAcct) {
		FeeAcct = feeAcct;
	}
	public String getAgentSign() {
		return AgentSign;
	}
	public void setAgentSign(String agentSign) {
		AgentSign = agentSign;
	}
	public String getComments() {
		return Comments;
	}
	public void setComments(String comments) {
		Comments = comments;
	}
	public FromAcct getFromAcct() {
		return fromAcct;
	}
	public void setFromAcct(FromAcct fromAcct) {
		this.fromAcct = fromAcct;
	}
	public List<TransDetail> getTransDetails() {
		return transDetails;
	}
	public void setTransDetails(List<TransDetail> transDetails) {
		this.transDetails = transDetails;
	}
	public Account(Integer clientId, String transWay, String businessType,
			String paymentCur, String paymentType, String purpose,
			String priority, String transDate, String transTime,
			String feeType, String feeAcct, String agentSign, String comments,
			FromAcct fromAcct, List<TransDetail> transDetails) {
		super();
		ClientId = clientId;
		TransWay = transWay;
		BusinessType = businessType;
		PaymentCur = paymentCur;
		PaymentType = paymentType;
		Purpose = purpose;
		Priority = priority;
		TransDate = transDate;
		TransTime = transTime;
		FeeType = feeType;
		FeeAcct = feeAcct;
		AgentSign = agentSign;
		Comments = comments;
		this.fromAcct = fromAcct;
		this.transDetails = transDetails;
	}
	public Account() {
		super();
	}
	@Override
	public String toString() {
		return "Account [ClientId=" + ClientId + ", TransWay=" + TransWay
				+ ", BusinessType=" + BusinessType + ", PaymentCur="
				+ PaymentCur + ", PaymentType=" + PaymentType + ", Purpose="
				+ Purpose + ", Priority=" + Priority + ", TransDate="
				+ TransDate + ", TransTime=" + TransTime + ", FeeType="
				+ FeeType + ", FeeAcct=" + FeeAcct + ", AgentSign=" + AgentSign
				+ ", Comments=" + Comments + ", fromAcct=" + fromAcct
				+ ", transDetails=" + transDetails + "]";
	}
	


}
