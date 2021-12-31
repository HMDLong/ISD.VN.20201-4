package controller;

import java.util.Hashtable;
import java.util.Map;

import caculatefee.CaculateFeeInterface;
import caculatefee.CaculateFeeV1;
import entity.bike.Bike;
import entity.dock.Dock;
import entity.rental.Rental;

public class ReturnBikeController extends BaseController {
	private Dock currentDock;
	private PaymentController payctl ;
	private Rental rental;
	
	public Dock getCurrentDock() {
		return currentDock;
	}

	public void setCurrentDock(Dock currentDock) {
		this.currentDock = currentDock;
	}
	
	
	public Map<String, String> returnBike(Bike bike, String cardNumber, String cardHolderName, String expirationDate,
			String securityCode) {
		payctl = new PaymentController();

		Map<String, String> result = new Hashtable<String, String>();
		result.put("RESULT", "RETURN FAILED!");

		int totalfFee = rental.getInvoice().getTotalMoney();
		int deposit = rental.getInvoice().getDepositFee();

		Map<String, String> announce;

		if (totalfFee > deposit) {
			announce = payctl.requestToPay("PAY RENTAL FEE" ,totalfFee - deposit, cardNumber, cardHolderName, expirationDate,
					securityCode);
		} else {
			announce = payctl.requestToRefund("PAY RENTAL FEE" ,deposit - totalfFee, cardNumber, cardHolderName, expirationDate,
					securityCode);
		}

		if (announce.get("RESULT").equals("PAYMENT SUCCESSFUL!")) {
			currentDock.returnBikeInDock(bike);
			result.put("RESULT", "RETURN SUCCESSFUL");
			
		}
		result.put("RESULT", announce.get("MESSAGE"));

		return result;
	}
	
	
	
	
	

}
