package com.terabits.meta.vo;

//充值记录中的金额，包含了用户充值和管理员充值两类，RechargeVO类取这两个数据的和，并转为整数，作为和前端的交互
public class RechargeVO {
	private String time;
	private String phone;
	private int money;

	
	
	public String getTime() {
		return this.time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getPhone() {
		return this.phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getMoney() {
		return this.money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
}
