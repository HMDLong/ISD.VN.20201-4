package controller;

import java.sql.SQLException;
import java.util.Date;
import java.util.Hashtable;
import java.util.Map;

import caculatefee.CaculateFeeInterface;
import caculatefee.CaculateFeeV1;
import common.exception.InvalidSearchKeyException;
import common.exception.NoResultException;
import entity.bike.Bike;
import entity.bike.Ebike;
import entity.dock.Dock;
import entity.invoice.Invoice;
import entity.payment.CreditCard;

/**
 * Controller class for rent bike use case.
 *
 * @author Group4
 *
 */
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
	
	/**
	 * This method rent bike from docks.
	 *
	 * @param cardNumber, cardHolderName, expirationDate, securityCode
	 * @return Map<String, String> list of result message for rent bike
	 * @throws SQLException 
	 */
	public Map<String, String> rentBike(String cardNumber, String cardHolderName,
			String expirationDate, String securityCode) throws SQLException 
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
			invoice.saveNewInvoice();
			currentDock.rentBikeFromDock(invoice.getBike());
			result.put("RESULT", "RENT SUCCESSFUL");
		}
		result.put("MESSAGE", announce.get("MESSAGE"));
		
		return result;
	}
	/**
	 * This method get bike detailed information.
	 *
	 * @param barCode
	 * @return Map<String, String> list of result message for bike information
	 */
	public Map<String, String> getBikeInfo(String barCode) {
		invoice = Invoice.getRentInvoice();
		String bikeCode = convertBarcodeToBikecode(barCode);
		Map<String, String> result = null ;
		Bike bike = currentDock.getBike(bikeCode);
		if (bike != null) {
			invoice.setBike(bike);
			invoice.getRentFeeInfor();
			if(bike.getBikeGenericType().equals("Bike")) {
				result = bike.getBikeInfo();
			}else
				result = ((Ebike) bike).getBikeInfo();
			if(invoice.getStatus() == 1) {
				result.put("STATE", "Renting");
			}
			result.put("RESULT", "SUCESSFULL");
			result.put("DEPOSIT", Integer.toString(invoice.getDepositFee()));
			result.put("RENTINFO", invoice.getRentFeeInfor());
			
		}
		else {
			result = new Hashtable<String, String>();
			result.put("RESULT", "BIKE NOT AVAILBLE");
		}
		return result;
	}
	/**
	 * This method convert barcode to bikecode.
	 *
	 * @param barcode
	 * @return bikecode
	 */
	public String convertBarcodeToBikecode(String barcode)
	{
		String bikeCode = barcode + "bike";
		return  bikeCode;
	}
	
}