package controller;

import java.util.Date;
import java.util.Hashtable;
import java.util.Map;

import caculatefee.CaculateFeeInterface;
import caculatefee.CaculateFeeV1;
import entity.bike.Bike;
import entity.dock.Dock;
import entity.invoice.Invoice;
import entity.payment.CreditCard;

public class RentBikeController extends BaseController 	
{
	private Dock currentDock;
	private PaymentController payctl ;
	private Invoice invoice;
	
	public Dock getCurrentDock() 
	{
		return currentDock;
	}

	public void setCurrentDock(Dock currentDock)
	{
		this.currentDock = currentDock;
	}
	
	
	public Map<String, String> rent(Bike bike,  String cardNumber, String cardHolderName,
			String expirationDate, String securityCode) 
	{
		
		invoice = Invoice.getRentInvoice();
		int depositMoney = invoice.getDepositFee();
		
		payctl  = new PaymentController();
		Map<String, String> result = new Hashtable<String, String>();
		result.put("RESULT", "RENT FAILED!");
				
		Map<String, String> announce = payctl.requestToPay("DEPOSIT FEE" ,depositMoney, cardNumber, cardHolderName, expirationDate, securityCode);
		if (announce.get("RESULT").equals("PAYMENT SUCCESSFUL!")) {
			invoice.setStartTime(new Date());
			invoice.setStatus(1);
			invoice.setDepositFee(depositMoney);
			currentDock.rentBikeFromDock(bike);
			result.put("RESULT", "RENT SUCCESSFUL");
		}
		result.put("RESULT", announce.get("MESSAGE"));
		
		return result;
	}
	
	public Map<String, String> getBikeInfo(String bikeCode) {
		Map<String, String> result = null ;
		Bike bike = currentDock.getBike(bikeCode);
		if (bike != null) {
			invoice.setBike(bike);
			invoice.getRentInfor();
			result = bike.getBikeInfo();
			result.put("RESULT", "SUCESSFULL");
			result.put("RENTINFO", bikeCode);
		}
		else {
			result = new Hashtable<String, String>();
			result.put("RESULT", "BIKE NOT AVAILBLE");
		}
		return result;
	}
	
	public String convertBarcodeToBikecode(String barcode)
	{
		String bikeCode = barcode + "bike";
		return  bikeCode;
	}
	
}
