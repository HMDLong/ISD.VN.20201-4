package caculatefee;

import entity.bike.Bike;

/**
 * 
 * @author Admin
 *
 */
public class CaculateFeeV1 implements CaculateFeeInterface {

	@Override
	public int caculateDepositFee(String bike) {
		// TODO Auto-generated method stub
		if(bike.equals("standard single"))
			return 400000;
		else if(bike.equals("standard twin"))
			return 550000;
		else if(bike.equals("electric single"))
			return 700000;
		else return 850000;
	}

	@Override
	public int caculateRentFee(String bike , float rentTime) {
		// TODO Auto-generated method stub
		int fee = (int)rentTime*10000;
		return fee;
	}

	@Override
	public String getInfoRental(String bike) {
		return "- If you return in under 10 minutes, your rental is free\n"
			 + "- For the first 30 minutes, you are charged VND 10.000\n"
			 + "- After 30 minutes, rental fee will be VND 3.000 per minutes";
	}
	
	

}