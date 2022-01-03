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
	private int remain_time;

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
	
	public void setRemainTime(int time) {
	  this.remain_time = time;
	}
	
	public int getRemainTime() {
	  return this.remain_time;
	}
	
	public String getBikeGenericType() {
	  return "Ebike";
	}
	
	/**
	 * This method get for detailed bike information
	 */
	public Map<String, String> getBikeInfo(){
		Map<String, String> info = super.getBikeInfo();
		info.put("BATTERY", Integer.toString(battery));
		return info;
	}
	
	/**
	 * Return an e-bike object, made from query result.
	 * @throws SQLException throws if error occurs during query
	 */
	public Ebike createBike(ResultSet res) throws SQLException {
	  Ebike bike = new Ebike();
      bike.setBikeType(res.getString("type_name"));
      bike.setBikeCode(res.getString("bike_code"));
      bike.setId(res.getInt("id"));
      bike.setImageURL(res.getString("image_url"));
      bike.setDeposit(res.getInt("deposit"));
      bike.setStatus(false);
      bike.setBattery(res.getInt("battery"));
      bike.setRemainTime(res.getInt("remain_time"));
      return bike;
	}
	
}