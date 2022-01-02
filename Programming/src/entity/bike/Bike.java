package entity.bike;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

import entity.db.EcoDB;
import factory.bike.BikeFactory;

/**
 * Represent bike object.
 *
 * @author Admin
 *
 */
public class Bike {
    private int id;
	private String bikeType;
	private boolean status;
	private String bikeCode;
	private String imageURL;
	
	public String getBikeType() {
		return bikeType;
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
	
	public  Map<String, String> getBikeInfo(){
		Map<String, String> info = new Hashtable<String, String>();
		info.put("TYPE", bikeType);
		info.put("BIKECODE", bikeCode);
		info.put("IMAGE_URL", imageURL);
		return info;
	}
	
	public static ArrayList<Bike> getBikesInDock(int dockId) throws SQLException{
	  ArrayList<Bike> bikelist = new ArrayList<>();
	  Statement stm = EcoDB.getConnection().createStatement();
	  String query = "select id, type_name, bike_code, image_url, battery "
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
	
	public Bike createBike(ResultSet res) throws SQLException {
	  Bike bike = new Bike();
      bike.setBikeType(res.getString("type_name"));
      bike.setBikeCode(res.getString("bike_code"));
      bike.setId(res.getInt("id"));
      bike.setImageURL(res.getString("image_url"));
      bike.setStatus(false);
      return bike;
	}
}