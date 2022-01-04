package caculatefee;

import entity.bike.Bike;

/**
 * An general interface for calculate fee. Other fee
 * calculators will implement this interface.
 *
 * @author Admin
 *
 */
public interface CaculateFeeInterface {
    /**
     * This method calculate deposit.
     *
     * @param bike biketype to determine the deposit.
     * @return the deposit amount.
     */
	public int caculateDepositFee(String bike);
	
	/**
	 * This method calculate rent fee.
	 *
	 * @param bike the biketype of the rent bike.
	 * @param rentTime total rent time.
	 * @return the rental fee.
	 */
	public int caculateRentFee(String bike , float rentTime);
	
	/**
	 * This method returns details about the rental method.
	 *
	 * @param bike the biketype.
	 * @return String the rental method represented in a string.
	 */
	public String getInfoRental(String bike);
}