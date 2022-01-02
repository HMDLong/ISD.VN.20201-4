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
		return 4000;
	}

	@Override
	public int caculateRentFee(String bike , float rentTime) {
		// TODO Auto-generated method stub
		int fee = (int)rentTime*10000;
		return fee;
	}

	@Override
	public String getWayCalculateFee(String bike) {
		return "duoi 10 phut ban duoc mien phi, 10000/h, ban phai dat coc 400,000.0 VND de thue xe";
	}
	
	

}