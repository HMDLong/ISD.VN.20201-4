package entity.invoice;

import java.util.Date;

import utils.MyTime;

public class Invoice {
	private String bikeType;
	private Date startTime;
	private int totaltime;
	private int totalMoney;
	private int depositFee;
	
	
	
	public int getDepositFee() {
		return depositFee;
	}
	public void setDepositFee(int depositFee) {
		this.depositFee = depositFee;
	}
	public String getBikeType() {
		return bikeType;
	}
	public void setBikeType(String bikeType) {
		this.bikeType = bikeType;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public int getTotaltime() {
		
		return totaltime;
	}
	public void setTotaltime(int totaltime) {
		this.totaltime = totaltime;
	}
	public int getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(int totalMoney) {
		this.totalMoney = totalMoney;
	}
	
	
}
