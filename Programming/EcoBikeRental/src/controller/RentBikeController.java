package controller;

import java.util.Hashtable;
import java.util.Map;

import caculatefee.CaculateFeeInterface;
import caculatefee.CaculateFeeV1;
import entity.bike.Bike;
import entity.dock.Dock;
import entity.payment.CreditCard;
import entity.rental.Rental;

public class RentBikeController extends BaseController 	
{
	private Dock currentDock;
	private PaymentController payctl ;
	private Rental rental;
	
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
		
		
		payctl  = new PaymentController();
		Map<String, String> result = new Hashtable<String, String>();
		result.put("RESULT", "RENT FAILED!");
		
		CaculateFeeInterface caculator = new CaculateFeeV1();
		int depositMoney = caculator.caculateDepositFee(bike);
		Map<String, String> announce = payctl.requestToPay("DEPOSIT FEE" ,depositMoney, cardNumber, cardHolderName, expirationDate, securityCode);
		if (announce.get("RESULT").equals("PAYMENT SUCCESSFUL!")) {
			currentDock.rentBikeFromDock(bike);
			
			result.put("RESULT", "RENT SUCCESSFUL");
		}
		result.put("RESULT", announce.get("MESSAGE"));
		
		return result;
	}
	
	public Bike getBikeInfo(String bikeCode) 
	{
		Bike bike = currentDock.getBike(bikeCode);
		return bike;
	}
	
	public String convertBarcodeToBikecode(String barcode)
	{
		String bikeCode = barcode + "bike";
		return  bikeCode;
	}
	
}
