package entity.dock;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entity.bike.Bike;
import entity.bike.Ebike;
import entity.db.EcoDB;

/**
 * Represent dock entity.
 *
 * @author Group4
 *
 */
public class Dock {
	  private int id;
	  private String address;
	  private String name;
	  private int maxSlot;
	  private int avaiSlot;
	  private int area;
	  private String imageUrl;
	  private static ArrayList<Dock> docklist;
	  
	  
	  public Dock(int id, String address, String name, int maxSlot, int availSlot, int area, String imgUrl) {
	    this.id = id;
	    this.address = address;
	    this.name = name;
	    this.maxSlot = maxSlot;
	    this.avaiSlot = availSlot;
	    this.area = area;
	    this.imageUrl = imgUrl;
	  }
	  
	  /**
		 * This method get for all dock in system.
		 *
		 * @return ArrayList<Dock> list of dock
		 * @throws SQLException throws if error occurs during query
		 */
	  public static ArrayList<Dock> getAllDocks() throws SQLException{
		if(docklist == null) {
		    docklist = new ArrayList<>();
		    Statement stm = EcoDB.getConnection().createStatement();
		    String query = "select * from docks;";
		    ResultSet res = stm.executeQuery(query);
		    while(res.next()) {
		      docklist.add(new Dock(res.getInt("id"),
		                            res.getString("address"),
		                            res.getString("name"),
		                            res.getInt("max_capacity"),
		                            res.getInt("avail_slot"),
		                            res.getInt("area"),
		                            res.getString("image_url")));
		      
		    }
		}
	    return docklist;
	  }
	  /**
		 * This method get for all bike in material dock.
		 *
		 * @return ArrayList<Bike> list of dock
		 * @throws SQLException throws if error occurs during query
		 */
	  public ArrayList<Bike> getBikes() throws SQLException{
	    return Bike.getBikesInDock(this.id);
	  }
	  /**
		 * This method check available empty slot in dock .
		 *
		 * @return boolean (true if full slot)
		 */
	  public boolean isFull() {
		return this.getMaxSlot()==this.getAvaiSlot();
	  }
	  
	  //----------Set get------------------ 
	  
	  public int getId() {
	    return id;
	  }
	
	  public int getAvaiSlot() {
	    return avaiSlot;
	  }
	
	  public void setAvaiSlot(int avaiSlot) {
	    this.avaiSlot = avaiSlot;
	  }
	
	  public String getAddress() {
	    return address;
	  }
	
	  public String getName() {
	    return name;
	  }
	
	  public int getMaxSlot() {
	    return maxSlot;
	  }
	  
	  public int getArea() {
	    return area;
	  }
	  
	  /**
		 * This method check success for return bike.
		 *
		 * @param bike
		 * @return boolean (true if return bike successfully)
		 */
	  public boolean returnBikeInDock(Bike bike) {
		 
		  return true;
	  } 
	  
	  /**
		 * This method check success for rent bike.
		 *
		 * @param bike
		 * @return boolean (true if rent bike successfully)
		 */
	  public boolean rentBikeFromDock(Bike bike) {
	      
		  return true;
	  }
	  
	  /**
		 * This method get bike from dock match the bikecode.
		 *
		 * @param bikecode
		 * @return Bike
		 */
	  public Bike getBike(String bikecode) {
		  Ebike bike = new Ebike();
		  bike.setId(1);
		  bike.setBikeType("Bike");
		  bike.setBikeCode("2222");
		  bike.setStatus(true);
		  bike.setImageURL("Url");
		  bike.setBattery(100);
		  return bike;
	  }  
}
