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
		return "Giá tiền thuê xe là 10000/h.Thuê dưới 10 phút bạn được miễn phí tiền đặt cọc, thuê trên 10 phút bạn phải đặt cọc với số tiền bằng 40% giá trị xe để thuê xe";
	}
	
	

}