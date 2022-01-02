package caculatefee;

import entity.bike.Bike;

public interface CaculateFeeInterface {
	public int caculateDepositFee(String bike);
	public int caculateRentFee(String bike , float rentTime);
	public String getWayCalculateFee(String bike);
}