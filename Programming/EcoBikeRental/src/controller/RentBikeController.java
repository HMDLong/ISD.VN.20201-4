package controller;

import java.util.Date;
import java.util.Hashtable;
import java.util.Map;

import caculatefee.CaculateFeeInterface;
import caculatefee.CaculateFeeV1;
import entity.bike.Bike;
import entity.bike.Ebike;
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
	
	
	public Map<String, String> rent(String cardNumber, String cardHolderName,
			String expirationDate, String securityCode) 
	{
		
		invoice = Invoice.getRentInvoice();
		int depositMoney = invoice.getDepositFee();
		
		payctl  = new PaymentController();
		Map<String, String> result = new Hashtable<String, String>();
		result.put("RESULT", "RENT FAILED!");
		
		invoice.setStartTime(new Date());
		invoice.setStatus(1);
		invoice.setDepositFee(depositMoney);
		currentDock.rentBikeFromDock(invoice.getBike());
		result.put("RESULT", "RENT SUCCESSFUL");
		result.put("MESSAGE", "HHH");
				
//		Map<String, String> announce = payctl.requestToPay("DEPOSIT FEE" ,depositMoney, cardNumber, cardHolderName, expirationDate, securityCode);
//		if (announce.get("RESULT").equals("PAYMENT SUCCESSFUL!")) {
//			invoice.setStartTime(new Date());
//			invoice.setStatus(1);
//			invoice.setDepositFee(depositMoney);
//			currentDock.rentBikeFromDock(invoice.getBike());
//			result.put("RESULT", "RENT SUCCESSFUL");
//		}
//		result.put("MESSAGE", announce.get("MESSAGE"));
		
		return result;
	}
	
	public Map<String, String> getBikeInfo(String barCode) {
		invoice = Invoice.getRentInvoice();
		String bikeCode = convertBarcodeToBikecode(barCode);
		Map<String, String> result = null ;
		Bike bike = currentDock.getBike(bikeCode);
		if (bike != null) {
			invoice.setBike(bike);
			invoice.getRentInfor();
			if(bike.getBikeType().equals("Bike")) {
				result = bike.getBikeInfo();
			}else
				result = ((Ebike) bike).getBikeInfo();
			result.put("RESULT", "SUCESSFULL");
			result.put("DEPOSIT", Integer.toString(invoice.getDepositFee()));
			result.put("RENTINFO", invoice.getRentInfor());
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