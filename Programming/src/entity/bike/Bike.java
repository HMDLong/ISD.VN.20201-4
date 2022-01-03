package entity.bike;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

import common.exception.InvalidSearchKeyException;
import common.exception.NoResultException;
import entity.db.EcoDB;
import factory.bike.BikeFactory;

/**
 * Represent bike object.
 *
 * @author Group4
 *
 */
public class Bike {
    private int id;
	private String bikeType;
	private boolean status;
	private String bikeCode;
	private String imageURL;
	private int deposit;
	
	public String getBikeType() {
		return bikeType;
	}
	
	public String getBikeGenericType() {
	  return "Bike";
	}
	
	public void setBikeType(String bikeType) {
		this.bikeType = bikeType;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getBikeCode() {
		return bikeCode;
	}
	public void setBikeCode(String bikeCode) {
		this.bikeCode = bikeCode;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	
	public void setId(int id) {
	  this.id = id;
	}
	
	public int getId() {
	  return this.id;
	}
	
	public void setDeposit(int deposit) {
	  this.deposit = deposit;
	}
	
	public int getDeposit() {
	  return this.deposit;
	}
	
	/**
	 * This method get for detailed bike information
	 *
	 * @return Map<String, String> list of bike info
	 */
	public  Map<String, String> getBikeInfo(){
		Map<String, String> info = new Hashtable<String, String>();
		info.put("TYPE", bikeType);
		info.put("BIKECODE", bikeCode);
		info.put("IMAGE_URL", imageURL);
		return info;
	}
	/**
	 * This method get for all bike in material dock.
	 *
	 * @param dockId
	 * @return ArrayList<Dock> list of result bike
	 * @throws SQLException throws if error occurs during query
	 */
	public static ArrayList<Bike> getBikesInDock(int dockId) throws SQLException{
	  ArrayList<Bike> bikelist = new ArrayList<>();
	  Statement stm = EcoDB.getConnection().createStatement();
	  String query = "select id, type_name, deposit, bike_code, image_url, battery, remain_time "
	               + "from (bikes join biketypes using (type_id)) left join ebikes using (id) "
	               + "where dock_id = " + dockId + ";";
	  ResultSet res = stm.executeQuery(query);
	  while(res.next()) {
	    Bike bike = BikeFactory.getFactory().create(res);
	    bike.setStatus(false);
	    bikelist.add(bike);
	  }
	  return bikelist;
	}
	
	public static Bike getBikeByBikecode(String bikecode, int dock_id) throws SQLException {
	  Bike bike = null;
	  Statement stm = EcoDB.getConnection().createStatement();
	  String query = String.format("select id, type_name, deposit, bike_code, image_url, battery, remain_time "
	               + "from ((select * from bikes where dock_id = %d and bike_code = '%s') as alias1 left join ebikes using (id))"
	               + " join biketypes using (type_id);", dock_id, bikecode);
	  ResultSet res = stm.executeQuery(query);
	  if(res.next()) {
	    bike = BikeFactory.getFactory().create(res);
	  }
	  return bike;
	}
	
	/**
	 * This method for create bike.
	 *
	 * @param ResultSet res
	 * @return bike
	 * @throws SQLException throws if error occurs during query
	 */
	public Bike createBike(ResultSet res) throws SQLException {
	  Bike bike = new Bike();
      bike.setBikeType(res.getString("type_name"));
      bike.setBikeCode(res.getString("bike_code"));
      bike.setId(res.getInt("id"));
      bike.setImageURL(res.getString("image_url"));
      bike.setDeposit(res.getInt("deposit"));
      bike.setStatus(false);
      return bike;
	}
}