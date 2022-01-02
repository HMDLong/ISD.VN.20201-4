package entity.bike;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

/**
 * Represent electric bike entity.
 *
 * @author Admin
 *
 */
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
	
	public Map<String, String> getBikeInfo(){
		Map<String, String> info = super.getBikeInfo();
		info.put("BATTERY", Integer.toString(battery));
		return info;
	}
	
	/**
	 * Return a bike object, made from query result.
	 */
	public Ebike createBike(ResultSet res) throws SQLException {
	  Ebike bike = new Ebike();
      bike.setBikeType(res.getString("type_name"));
      bike.setBikeCode(res.getString("bike_code"));
      bike.setId(res.getInt("id"));
      bike.setImageURL(res.getString("image_url"));
      bike.setStatus(false);
      bike.setBattery(res.getInt("battery"));
      return bike;
	}
	
}