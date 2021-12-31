package entity.bike;

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
	
	
}
