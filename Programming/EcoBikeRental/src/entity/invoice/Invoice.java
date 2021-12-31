package entity.invoice;

import java.util.Date;

import caculatefee.CaculateFeeInterface;
import caculatefee.CaculateFeeV1;
import entity.bike.Bike;
import utils.MyTime;

public class Invoice {
	private Bike bike ;
	private Date startTime;
	private int totaltime;
	private int totalMoney;
	private int depositFee;
	private int status=0;


	private static Invoice rentInvoice;
	
	
	
	
	
	
	
	public static Invoice getRentInvoice() {
		if (rentInvoice == null) 
		{
			rentInvoice = new Invoice();
		}
		return rentInvoice;
	}

	public String getRentInfor() {
		CaculateFeeInterface caculator = new CaculateFeeV1();
		return caculator.getWayCalculateFee(bike.getBikeType());
	}

	public  void saveRentInvoice() {};
	public  void resetInvoice() {
		this.status = 0;
	};
	
	public Bike getBike() {
		return bike;
	}
	public void setBike(Bike bike) {
		this.bike = bike;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public int getTotaltime() {
		int totalTime = MyTime.getDifferenceTimes(this.getStartTime(), new Date());
		setTotaltime(totalTime);
		return totaltime;
	}
	public void setTotaltime(int totaltime) {
		this.totaltime = totaltime;
	}
	public int getTotalMoney() {
		CaculateFeeInterface caculator = new CaculateFeeV1();
		int rentime = getTotaltime();
		int fee = caculator.caculateRentFee(bike.getBikeType(), rentime);
		setTotalMoney(fee);
		return fee;
	}
	public void setTotalMoney(int totalMoney) {
		this.totalMoney = totalMoney;
	}
	public int getDepositFee() {
		CaculateFeeInterface caculator = new CaculateFeeV1();
		return caculator.caculateDepositFee(bike.getBikeType());
	}
	public void setDepositFee(int depositFee) {
		this.depositFee = depositFee;
	}
	
	public boolean isRenting() {
		return (this.status==1);
	}
	
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}









	
	
	

	
	
}
