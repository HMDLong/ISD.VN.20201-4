package caculatefee;

import entity.bike.Bike;

public interface CaculateFeeInterface {
	public int caculateDepositFee(Bike bike);
	public int caculateRentFee(Bike bike , float rentTime);
}
