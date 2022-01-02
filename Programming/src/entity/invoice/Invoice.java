package entity.invoice;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.Map;
import java.util.Random;

import caculatefee.CaculateFeeInterface;
import caculatefee.CaculateFeeV1;
import entity.bike.Bike;
import utils.MyTime;

/**
 * Represent an invoice.
 *
 * @author Admin
 *
 */
public class Invoice {
	private Bike bike ;
	private int id;
	private Date startTime;
	private int totalTime;
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
		Random rand = new Random();
		this.id = rand.nextInt(1000000)+1;
		this.startTime = startTime;
	}
	public int getTotalTime() {
		int totalTime = MyTime.getDifferenceTimes(this.getStartTime(), new Date());
		setTotalTime(totalTime);
		return totalTime;
	}
	public void setTotalTime(int totaltime) {
		this.totalTime = totaltime;
	}
	public int getTotalMoney() {
		CaculateFeeInterface caculator = new CaculateFeeV1();
		int rentime = getTotalTime();
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Map<String, String> getInvoiceInfo() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
		String start = dateFormat.format(this.startTime);
		String rentTime = Integer.toString(getTotalTime());
		int refund = depositFee - totalMoney;
		if (refund < 0) refund = 0;
		int paymoney = totalMoney - depositFee;
		if (paymoney < 0) paymoney = 0;

		
		Map<String, String> info =  new Hashtable<String, String>();
		info.put("INVOICE_ID", Integer.toString(this.id));
		info.put("START", start);
		info.put("REN_TIME", rentTime);
		info.put("BIKE_ID", bike.getBikeCode());
		info.put("RENT_TYPE", "standard");
		info.put("DEPOSIT_MONEY", Integer.toString(depositFee));
		info.put("RENT_FEE", Integer.toString(totalMoney));
		info.put("REFUND", Integer.toString(refund));
		info.put("AMOUNT", Integer.toString(paymoney));

		return info;
	}
}