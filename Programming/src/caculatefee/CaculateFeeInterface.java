package caculatefee;

import entity.bike.Bike;

public interface CaculateFeeInterface {
    /**
     * 
     * @param bike
     * @return
     */
	public int caculateDepositFee(String bike);
	
	/**
	 * 
	 * @param bike
	 * @param rentTime
	 * @return
	 */
	public int caculateRentFee(String bike , float rentTime);
	
	/**
	 * 
	 * @param bike
	 * @return String
	 */
	public String getInfoRental(String bike);
}