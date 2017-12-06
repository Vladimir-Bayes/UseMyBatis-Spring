package com.terabits.meta.vo;

//ConsumesVO类用于获取原始的double类型的消费数据

public class ConsumesVO {
	private String phone;
	private String station;
	private String boxId;
	private String time;
	private Double money;
	
	
	public String getPhone() {
		return this.phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getStation() {
		return this.station;
	}
	public void setStation(String station) {
		this.station = station;
	}
	public String getBoxId() {
		return this.boxId;
	}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	public String getTime() {
		return this.time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	
}
