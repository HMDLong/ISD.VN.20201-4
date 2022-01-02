package entity.bike;

import java.util.Map;

public class Ebike extends Bike {
	private int battery;

	public int getBattery() {
		return battery;
	}

	public void setBattery(int battery) {
		if(battery > 100) {
			battery = 100;
		}
		if(battery < 0) {
			battery = 0;
		}
		this.battery = battery;
	}
	
	public  Map<String, String> getBikeInfo(){
		Map<String, String> info = super.getBikeInfo();
		info.put("BATTERY", Integer.toString(battery));
		return info;
		
	}
	
}