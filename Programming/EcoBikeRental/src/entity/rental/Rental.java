package entity.rental;

import java.time.LocalDateTime;
import java.util.Date;

import caculatefee.CaculateFeeInterface;
import caculatefee.CaculateFeeV1;
import entity.bike.Bike;
import entity.invoice.Invoice;
import utils.MyTime;

public class Rental {
	private Bike bike;
	private Invoice invoice;
	
	private Rental rental;
	
	
	private Rental() {};
	
	
	public Rental getRental() {
		if (rental == null) {
			rental = new Rental();
		}
		return rental;
	}
	
	
	public void setRental(Bike bike, Date rentStartTime, int depositFee) {
		invoice = new Invoice();
		this.bike = bike;
		this.invoice.setBikeType(bike.getBikeType());
		this.invoice.setStartTime(rentStartTime);
		this.invoice.setDepositFee(depositFee);
		
	}
	
	public boolean isRenting() {
		return (this.bike!=null);
	}
	
	public void resetRental() {
		setRental(null, null, 0);
	}
	
	public Invoice getInvoice() {
		CaculateFeeInterface caculator = new CaculateFeeV1();		
		int totalTime = MyTime.getDifferenceTimes(this.invoice.getStartTime(), new Date());
		
		int totalFee = caculator.caculateRentFee(bike, totalTime);
		
		this.invoice.setTotaltime(totalTime);
		this.invoice.setTotalMoney(totalFee);
		
		return  this.invoice;
	}
	
	private void saveInvoice() {};

	
}
