package com.terabits.meta.vo;

//充值记录中的金额，包含了用户充值和管理员充值两类，RechargesVO类用于获取这两个原始的double类型数据

public class RechargesVO {
	private String time;
	private String phone;
	private double payment;
	private double present;
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public double getPayment() {
		return payment;
	}
	public void setPayment(double payment) {
		this.payment = payment;
	}
	public double getPresent() {
		return present;
	}
	public void setPresent(double present) {
		this.present = present;
	}
	
	

}
