package caculatefee;

import entity.bike.Bike;

public class CaculateFeeV1 implements CaculateFeeInterface {

	@Override
	public int caculateDepositFee(Bike bike) {
		// TODO Auto-generated method stub
		int fee = (int) ((int) bike.getPrice()*0.4);
		return fee;
	}

	@Override
	public int caculateRentFee(Bike bike , float rentTime) {
		// TODO Auto-generated method stub
		int fee = (int)rentTime*10000;
		return fee;
	}

}
